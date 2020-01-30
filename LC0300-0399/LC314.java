// Binary Tree Vertical Order Traversal  二叉树的垂直遍历

@MEDIUM
class LC314 {

  @BFS
  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();
    
    List<List<Integer>> left = new ArrayList<>();
    List<Integer> mid = new ArrayList<>();
    List<List<Integer>> right = new ArrayList<>();
    
    Elem e = new Elem(root, 0);
    Queue<Elem> queue = new LinkedList<>();
    queue.offer(e);
    
    
    while (!queue.isEmpty()) {
      Elem tmp = queue.poll();
      
      if (tmp.height == 0) mid.add(tmp.node.val);
      
      if (tmp.height < 0) {
        if (-tmp.height > left.size()) left.add(new ArrayList<>());
        left.get(-tmp.height - 1).add(tmp.node.val);
      }
      
      if (tmp.height > 0) {
        if (right.size() < tmp.height) right.add(new ArrayList<>());
        right.get(tmp.height - 1).add(tmp.node.val);
      }
      
      if (tmp.node.left != null) {
        queue.offer(new Elem(tmp.node.left, tmp.height - 1));
      }
      
      if (tmp.node.right != null) {
        queue.offer(new Elem(tmp.node.right, tmp.height + 1));
      }
    }
    
    Collections.reverse(left);
    left.add(mid);
    left.addAll(right);
    
    return left;
  }
}

class Elem {
  TreeNode node;
  int height;
  Elem(TreeNode node, int col) {
    this.node = node;
    this.height = col;
  }
}