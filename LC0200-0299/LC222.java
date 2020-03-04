// Count Complete Tree Nodes 完全二叉树的节点个数

@MEDIUM
public class LC222 {

  @Tree
  @BinarySearch
  public int countNodes(TreeNode root) {
    if (root == null) return 0;

    int h = 0;
    TreeNode copy = root;

    for (; copy != null; h++) copy = copy.left;
    if (h == 1) return 1;

    int start = (int) Math.pow(2, h - 1);
    int end = start * 2 - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (binarySearchOnLeaves(root, mid, h)) start = mid;
      else end = mid;
    }

    if (binarySearchOnLeaves(root, end, h)) return end;
    return start;
  }

  private boolean binarySearchOnLeaves(TreeNode node, int index, int h) {
    int[] steps = new int[h - 1];

    for (int i = h - 2; i >= 0; i--) {
      steps[i] = index % 2;
      index /= 2;
    }

    for (int step : steps) {
      if (step == 0 && node.left != null) node = node.left;
      else if (step == 1 && node.right != null) node = node.right;
      else return false;
    }

    return true;
  }
}
