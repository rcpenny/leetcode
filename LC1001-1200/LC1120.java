// Maximum Average Subtree

// 树中的节点数介于 1 到 5000之间。
// 每个节点的值介于 0 到 100000 之间

@MEDIUM
public class LC1120 {
  double maxAvg = DOUBLE.NEGATIVE_INFINITY;

  @DivideConquer
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