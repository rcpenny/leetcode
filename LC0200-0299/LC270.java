// Closest Binary Search Tree Value 最接近的二叉搜索树值

@EASY
public class LC270 {

	@BinarySearch
  public int closestValue(TreeNode root, double target) {
    int result = root.val;
    double diff = Double.MAX_VALUE;

    while (root != null) {
      if (Math.abs(root.val - target) < diff) {
        result = root.val;
        diff = Math.abs(root.val - target);
      }

      if (root.val < target) root = root.right;
      else root = root.left;
    }

    return result;
  }
}
