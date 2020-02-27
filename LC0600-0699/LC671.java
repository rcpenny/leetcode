// Second Minimum Node In a Binary Tree 二叉树中第二小的节点

@EASY
public class LC671 {

  @DivideConquer
  @BottomUp
  public int findSecondMinimumValue(TreeNode root) {
    if (root.left == null && root.right == null) {
      return -1;
    }

    int left = root.left.val != root.val ? root.left.val : findSecondMinimumValue(root.left);
    int right = root.right.val != root.val ? root.right.val : findSecondMinimumValue(root.right);

    if (left == -1) return right;
    if (right == -1) return left;
    
    return Math.min(left, right);
  }
}