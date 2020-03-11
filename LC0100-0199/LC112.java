// Path Sum 路径总和

@EASY
public class LC112 {

  @TopDown
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    if (root.left == null && root.right == null) return root.val == sum;

    boolean leftExists = hasPathSum(root.left, sum - root.val);
    boolean rightExists = hasPathSum(root.right, sum - root.val);

    return leftExists || rightExists;
  }
}
