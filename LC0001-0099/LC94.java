// Binary Tree Inorder Traversal 二叉树的中序遍历

@MEDIUM
public class LC94 {

	@Recursive
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();

		traverse(root, result);

		return result;
	}

	private void traverse(TreeNode node, List<Integer> result) {
		if (node == null) return;

		traverse(node.left, result);
		result.add(node.val);
		traverse(node.right, result);
	}

  @Iterative
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    pushToStack(root, stack);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      result.add(node.val);

      if (node.right != null) {
        pushToStack(node.right, stack);
      }
    }

    return result;
  }

  private void pushToStack(TreeNode node, Stack<TreeNode> stack) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}
