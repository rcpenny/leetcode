// Lowest Common Ancestor of a Binary Tree 二叉树的最近公共祖先

@MEDIUM
@Microsoft
public class LC236 {

  @DivideConquer
  @BottomUp
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (root == p || root == q) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) return root;

    return left != null ? left : right;
  }
}
