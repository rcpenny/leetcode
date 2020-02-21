// Sum Root to Leaf Numbers 求根到叶子节点数字之和

@MEDIUM
public class LC129 {
  int sum = 0;

  @DFS
  public int sumNumbers(TreeNode root) {
    if (root == null) return sum;
    dfs(root, 0);
    return sum;
  }

  private void dfs(TreeNode node, int path) {
    path += node.val;

    if (node.left == null && node.right == null) {
      sum += path;
      return;
    }

    if (node.left != null) dfs(node.left, path * 10);
    if (node.right != null) dfs(node.right, path * 10);
  }
}