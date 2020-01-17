// Validate Binary Search Tree 验证二叉搜索树

@MEDIUM
class LC98 {

  @DivideConquer
  @TopDown
  public boolean isValidBST(TreeNode root) {
    return check(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }

  private boolean check(TreeNode node, long upperBound, long lowerBound) {
    if (node == null) return true;

    if (node.val <= lowerBound || node.val >= upperBound) return false;

    boolean left = check(node.left, node.val, lowerBound);
    boolean right = check(node.right, upperBound, node.val);

    return left && right;
  }
}
