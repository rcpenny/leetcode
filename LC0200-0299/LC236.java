// Lowest Common Ancestor of a Binary Tree

@MEDIUM
@Microsoft
public class LC236 {

  @DivideConquer
  @BottomUp
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return bottomUp(root, p, q).ancestor;
  }

  private Info bottomUp(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null) return new Info(false, false, null);

    Info left = bottomUp(node.left, p, q);
    Info right = bottomUp(node.right, p, q);

    if (left.ancestor != null) return left;
    if (right.ancestor != null) return right;

    boolean pFound = left.pFound || right.pFound || node.val == p.val;
    boolean qFound = left.qFound || right.qFound || node.val == q.val;
    TreeNode ancestor = (pFound && qFound) ? node : null;

    return new Info(pFound, qFound, ancestor);
  }

  class Info {
    boolean pFound;
    boolean qFound;
    TreeNode ancestor;

    Info(boolean pFound, boolean qFound, TreeNode ancestor) {
      this.pFound = pFound;
      this.qFound = qFound;
      this.ancestor = ancestor;
    }
  }
}


