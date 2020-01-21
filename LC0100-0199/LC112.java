// Path Sum 路径总和

@EASY
public class LC112 {

  @DivideConquer
  @TopDown
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;

    if (root.left == null && root.right == null) {
      if (root.val == sum) return true;
      return false;
    }

    boolean leftResult = hasPathSum(root.left, sum - root.val);
    boolean rightResult = hasPathSum(root.right, sum - root.val);

    return leftResult || rightResult;
  }
}
