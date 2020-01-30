// N-ary Tree Level Order Traversal N叉树的层序遍历

@MEDIUM
public class LC429 {

  @BFS
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        level.add(node.val);
        for (Node child : node.children) {
          queue.offer(child);
        }
      }
      result.add(level);
    }

    return result;
  }
}