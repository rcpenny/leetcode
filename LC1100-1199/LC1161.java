// Maximum Level Sum of a Binary Tree

@MEDIUM
public class LC1161 {

  @BFS
  public int maxLevelSum(TreeNode root) {
    int max = root.val;
    int level = 1;
    int result = level;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      int sum = 0;

      for (int i = 0; i < size; i++) {
        TreeNode tmp = queue.poll();
        sum += tmp.val;
        if (tmp.left != null) queue.offer(tmp.left);
        if (tmp.right != null) queue.offer(tmp.right);
      }

      if (sum > max) {
        max = sum;
        result = level;
      }
      level++;
    }

    return result;
  }
}