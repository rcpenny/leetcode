// Binary Tree Right Side View 二叉树的右视图

@MEDIUM
@HighFreq
public class LC199 {

	@BFS
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    
    if (root == null) return result;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while(!queue.isEmpty()) {
      int size = queue.size();
      
      for (int i = 0; i < size; i++) {
        TreeNode tmp = queue.poll();
        if (tmp.left != null) queue.offer(tmp.left);
        if (tmp.right != null) queue.offer(tmp.right);
        
        if (i == size - 1) result.add(tmp.val);
      }
    }
    
    return result;
  }
}
