// Binary Tree Level Order Traversal II 二叉树的层次遍历 II

@EASY
public class LC107 {

	@BFS
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> results = new ArrayList<>();
    if (root == null) return results;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
        level.add(node.val);
      }
      results.add(level);
    }

    Collections.reverse(results);
    return results;
  }
}
