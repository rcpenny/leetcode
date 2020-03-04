// Binary Tree Upside Down 上下翻转二叉树 

@MEDIUM
public class LC156 {

	@Recursion
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		return helper(null, root);
	}

	private TreeNode helper(TreeNode parent, TreeNode node) {
		if (node == null) return parent;

		TreeNode newRoot = helper(node, node.left);

		if (parent != null) node.left = parent.right;
		else node.left = null;
		
		node.right = parent;

		return newRoot;
	}
}
