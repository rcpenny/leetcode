// Invert Binary Tree 翻转二叉树

@EASY
public class LC226 {

	@BottomUp
	public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    TreeNode left = invertTree(root.right);
    TreeNode right = invertTree(root.left);

    root.left = left;
    root.right = right;

    return root;
  }
}
