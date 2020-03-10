// Univalued Binary Tree 单值二叉树

@EASY
public class LC965 {

	@TopDown
  public boolean isUnivalTree(TreeNode root) {
    if (root == null) return true;

    if (root.left != null && root.left.val != root.val) return false;
    if (root.right != null && root.right.val != root.val) return false;

    return isUnivalTree(root.left) && isUnivalTree(root.right);
  }
}
