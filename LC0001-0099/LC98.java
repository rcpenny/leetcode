// Validate Binary Search Tree 验证二叉搜索树

@MEDIUM
@HighFreq
class LC98 {

  @TopDown
  public boolean isValidBST(TreeNode root) {
    return check(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }

  private boolean check(TreeNode node, long upperBound, long lowerBound) {
    if (node == null) return true;

    if (node.val <= lowerBound || node.val >= upperBound) return false;

    boolean leftValid = check(node.left, node.val, lowerBound);
    boolean rightValid = check(node.right, upperBound, node.val);

    return leftValid && rightValid;
  }
}
