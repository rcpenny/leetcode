// Maximum Average Subtree 子树的最大平均值

@MEDIUM
public class LC1120 {
  double maxAvg = DOUBLE.NEGATIVE_INFINITY;

	@BottomUp
  public double maximumAverageSubtree(TreeNode root) {
    if (root == null) return maxAvg;

    subtreeInfo(root);

    return maxAvg;
  }

  private TreeInfo subtreeInfo(TreeNode node) {
    if (node == null) return new TreeInfo(0, 0);

    TreeInfo left = subtreeInfo(node.left);
    TreeInfo right = subtreeInfo(node.right);

    int size = left.size + right.size;
    int sum = left.sum + right.sum;

    maxAvg = Math.max(maxAvg, sum * 1.0 / size);

    return new TreeInfo(size, sum);
  }

  class TreeInfo {
    int size;
    int sum;

    TreeInfo(int size, int sum) {
      this.size = size;
      this.sum = sum;
    }
  }
}
