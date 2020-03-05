// Find Largest Value in Each Tree Row 在每个树行中找最大值

@MEDIUM
public class LC515 {

	@BFS
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()) {
      int size = queue.size();
      int max = Integer.MIN_VALUE;

      for (int i = 0; i < size; i++) {
        TreeNode tmp = queue.poll();
        max = Math.max(max, tmp.val);
        if (tmp.left != null) queue.offer(tmp.left);
        if (tmp.right != null) queue.offer(tmp.right);
      }

      result.add(max);
    }

    return result;
  }
}
