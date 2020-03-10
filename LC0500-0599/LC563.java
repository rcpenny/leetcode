// Binary Tree Tilt 二叉树的坡度

@EASY
public class LC563 {
  int tilt = 0;

	@BottomUp
  public int findTilt(TreeNode root) {
    treeSum(root);
    return tilt;
  }

  private int treeSum(TreeNode node) {
    if (node == null) return 0;

    int leftSum = treeSum(node.left);
    int rightSum = treeSum(node.right);

    tilt += Math.abs(leftSum - rightSum);

    return leftSum + rightSum + node.val;
  }
}
