// Flatten Binary Tree to Linked List 二叉树展开为链表

@MEDIUM
public class LC114 {

	@Tree
  public void flatten(TreeNode root) {
		if (root == null) return;

		if (root.left != null) {
			TreeNode lastNode = leftTreeLastNode(root.left);

			lastNode.right = root.right;
			root.right = root.left;
			root.left = null;
		}

		flatten(root.right);
	}

	private TreeNode leftTreeLastNode(TreeNode node) {
		while (node.right != null) node = node.right;
		return node;
	}
}
