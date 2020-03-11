// Binary Tree Maximum Path Sum 二叉树中的最大路径和

@HARD
public class LC124 {
  int max = Integer.MIN_VALUE;

  @BottomUp
  public int maxPathSum(TreeNode root) {
    maxSumWithNode(root);
    return max;
  }

  public int maxSumWithNode(TreeNode node) {
    if (node == null) return 0;

    int left = maxSumWithNode(node.left);
    int right = maxSumWithNode(node.right);
    
    max = Math.max(max, left + right + node.val);

    return Math.max(0, Math.max(left, right) + node.val);
  }
}
