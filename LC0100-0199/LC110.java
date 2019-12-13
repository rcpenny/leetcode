// Balanced Binary Tree

@EASY
public class LC110 {
  private boolean balanced = true;

  @DivideConquer
  public boolean isBalanced(TreeNode root) {
    treeHeight(root);

    return balanced;
  }

  private int treeHeight(TreeNode node) {
    if (!balanced || node == null) return 0;

    int left = treeHeight(node.left);
    int right = treeHeight(node.right);

    balanced = Math.abs(left - right) > 1 ? false : balanced;

    return Math.max(left, right) + 1;
  }
}
