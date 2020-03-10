// Increasing Order Search Tree 递增顺序查找树

@EASY
public class LC897 {

	@Iterative
  public TreeNode increasingBST(TreeNode root) {
    TreeNode result = root;
    while (result.left != null) result = result.left;

    Stack<TreeNode> stack = new Stack<>();
    pushToStack(stack, root);

    while (!stack.isEmpty()) {
      TreeNode tmp = stack.pop();
      pushToStack(stack, tmp.right);
      tmp.left = null;

      if (!stack.isEmpty()) tmp.right = stack.peek();
    }

    return result;
  }

  private void pushToStack(Stack<TreeNode> stack, TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }


	TreeNode cur;

	@Recursion
	public TreeNode increasingBST(TreeNode root) {
		TreeNode ans = new TreeNode(0);
		cur = ans;

		inorder(root);
		
		return ans.right;
	}

	public void inorder(TreeNode node) {
		if (node == null) return;
		
		inorder(node.left);

		node.left = null;
		cur.right = node;
		cur = node;
		
		inorder(node.right);
	}
}
