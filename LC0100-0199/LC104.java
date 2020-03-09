// Maximum Depth of Binary Tree 二叉树的最大深度

@EASY
public class LC104 {

  @BottomUp
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    return Math.max(left, right) + 1;
  }
}

/**
 * 思路：
 * 分治左右子树的高度，选更高的 加上root node
 */
