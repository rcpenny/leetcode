// Populating Next Right Pointers in Each Node II 填充每个节点的下一个右侧节点指针 II

@MEDIUM
class LC117 {

  @BFS
  public Node connect(Node root) {
    if (root == null) return root;

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      Node prev = null;

      for (int i = 0; i < size; i++) {
        Node cur = queue.poll();

        if (i > 0) {
          prev.next = cur;
        }

        prev = cur;

        if (cur.left != null) {
          queue.offer(cur.left);
        }

        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }

    return root;
  }
}
