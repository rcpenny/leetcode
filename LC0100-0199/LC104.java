// Maximum Depth of Binary Tree 二叉树的最大深度

@EASY
public class LC104 {

  @DivideConquer
  @BottomUp
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    return Math.max(left, right) + 1;
  }
}
