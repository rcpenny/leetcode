// Balanced Binary Tree 平衡二叉树

@EASY
public class LC110 {

  @BottomUp
  public boolean isBalanced(TreeNode root) {
    return treeHeight(root) != -1;
  }

  private int treeHeight(TreeNode node) {
    if (node == null) return 0;

    int leftHeight = treeHeight(node.left);
    int rightHeight = treeHeight(node.right);
		
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
			return -1;

    return Math.max(leftHeight, rightHeight) + 1;
  }
}

/**
 * 思路：
 * 此题等于max depth of binary tree，若两个subtree高度差 > 1，返回 -1
 */
