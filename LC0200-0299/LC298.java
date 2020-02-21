// Binary Tree Longest Consecutive Sequence 二叉树最长连续序列

@MEDIUM
public class LC298 {

	int longestPath = 0;

	@Tree
  public int longestConsecutive(TreeNode root) {
    if (root == null) return 0;

    dfs(root, 1, root.val);
    return longestPath;
  }

  private void dfs(TreeNode node, int curPath, int lastVal) {    
    if (node == null) return;

    longestPath = Math.max(longestPath, curPath);

    if (node.left != null) {
      if (lastVal + 1 == node.left.val) dfs(node.left, curPath + 1, node.left.val);
      else dfs(node.left, 1, node.left.val);
    }

    if (node.right != null) {
      if (lastVal + 1 == node.right.val) dfs(node.right, curPath + 1, node.right.val);
      else dfs(node.right, 1, node.right.val);
    }
  }
}
