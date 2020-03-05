// Sum of Left Leaves 左叶子之和

@EASY
class LC404 {

	@BottomUp
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
      
    int sum = 0;

    if (root.left != null && root.left.left == null && root.left.right == null) {
      sum += root.left.val;
		}
    
    sum += sumOfLeftLeaves(root.left);
    sum += sumOfLeftLeaves(root.right);
    
    return sum;
  }
}
