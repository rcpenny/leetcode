// Binary Tree Postorder Traversal 二叉树的后序遍历

@HARD
public class LC145 {
	
	@Recursive
	public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    traverse(root, result);
    return result;
  }

  private void  traverse(TreeNode node, List<Integer> result) {
    if (node == null) return;

    traverse(node.left, result);
    traverse(node.right, result);
    result.add(node.val);
  }


	@Iterative
	// 后序遍历： 左 右 中 (出栈顺序)
	// 倒置打印前序遍历
	public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
		if (root == null) return result;

    Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

    while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();

			result.add(tmp.val);
			if (tmp.left != null) stack.push(tmp.left);
			if (tmp.right != null) stack.push(tmp.right);
    }

		Collections.reverse(result);
    return result;
  }
}
