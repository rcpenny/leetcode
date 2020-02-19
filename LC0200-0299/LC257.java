// Binary Tree Paths 二叉树的所有路径

@EASY
public class LC257 {

	@DFS
	@Tree
	public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    if (root == null) return paths;

    dfs(root, String.valueOf(root.val), paths);

    return paths;
  }

  private void dfs(TreeNode node, String tmpPath, List<String> paths) {
    if (node.left == null && node.right == null) {
      paths.add(tmpPath);
      return;
    }

    if (node.left != null) {
      dfs(node.left, tmpPath + "->" + String.valueOf(node.left.val), paths);
    }

    if (node.right != null) {
      dfs(node.right, tmpPath + "->" + String.valueOf(node.right.val), paths);
    }
  }
}
