// Minimum Absolute Difference in BST 二叉搜索树的最小绝对差

@EASY
public class LC530 {
  TreeNode prev = null;
  int diff = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {
    inorder(root);
    return diff;
  }

  private void inorder(TreeNode node) {
    if (node == null) return;

    inorder(node.left);
    
    diff = prev != null ? Math.min(diff, node.val - prev.val) : diff;
    prev = node;

    inorder(node.right);
  }
}
