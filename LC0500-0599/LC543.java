// Diameter of Binary Tree 二叉树的直径

@EASY
class LC543 {
  int longest = 1;

  @BottomUp
  public int diameterOfBinaryTree(TreeNode root) {
    bottomUp(root);
    return longest - 1;
  }

  private int bottomUp(TreeNode node) {
    if (node == null) return 0;

    int leftLen = bottomUp(node.left);
    int rightLen = bottomUp(node.right);

    longest = Math.max(longest, leftLen + rightLen + 1);

    return Math.max(leftLen, rightLen) + 1;
  }
}
