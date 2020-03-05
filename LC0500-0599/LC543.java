// Diameter of Binary Tree 二叉树的直径

@EASY
class LC543 {
  int max = Integer.MIN_VALUE;

  @DivideConquer
  @BottomUp
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    helper(root);
    return max - 1;
  }

  private int helper(TreeNode node) {
    if (node == null) return 0;

    int left = helper(node.left);
    int right = helper(node.right);

    max = Math.max(max, left + right + 1);

    return Math.max(left, right) + 1;
  }
}
