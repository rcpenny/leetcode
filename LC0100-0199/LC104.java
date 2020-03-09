// Maximum Depth of Binary Tree 二叉树的最大深度

@EASY
public class LC104 {

  @BottomUp
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int leftHeight = maxDepth(root.left);
    int rightHeight = maxDepth(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }
}

/**
 * 思路：
 * 分治左右子树的高度，选更高的 加上root node
 */
