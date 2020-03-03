// Binary Tree Zigzag Level Order Traversal 二叉树的锯齿形层次遍历

@MEDIUM
public class LC103 {

  @BFS
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    boolean evenLevel = false;
    while (!queue.isEmpty()) {
      int size = queue.size();

      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode tmp = queue.poll();
        
        if (tmp.left != null) queue.offer(tmp.left);
        if (tmp.right != null) queue.offer(tmp.right);

        list.add(tmp.val);
      }

      if (evenLevel) Collections.reverse(list);
      evenLevel = !evenLevel;
      result.add(list);
    }

    return result;
  }
}
