// Binary Tree Preorder Traversal 二叉树的前序遍历

@MEDIUM
public class LC144 {

  @Iterative
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    while (!stack.isEmpty()) {
      
    }

    return result;
  }
  
  @DFS
  public List<Integer> preorderTraversal1(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traverse(root, result);
    return result;
  }

  private void traverse(TreeNode node, List<Integer> result) {
    if (node == null) return;
    result.add(node.val);
    traverse(node.left, result);
    traverse(node.right, result);
  }
}