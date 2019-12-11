// Populating Next Right Pointers in Each Node

// challenge: 使用常量级额外空间

@MEDIUM
class LC116 {

  @Recursive
  public Node connect1(Node root) {
    if (root == null) return root;

    Node left = root.left;
    Node right = root.right;

    // 像拉拉链！
    while (left != null) {
      left.next = right;
      left = left.right;
      right = right.left;
    }

    connect(root.left);
    connect(root.right);

    return root;
  }


  
  @BFS
  public Node connect2(Node root) {
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
          queue.offer(cur.right);
        }
      }
    }

    return root;
  }
}
