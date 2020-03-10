// Two Sum BSTs 查找两棵二叉搜索树之和

@MEDIUM
class LC1214 {

	@TwoPointers
	@IterativeTraversal
  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    Stack<TreeNode> left = new Stack<>();
    Stack<TreeNode> right = new Stack<>();

    pushLeft(left, root1);
    pushRight(right, root2);

    TreeNode ln = leftInorderNext(left);
    TreeNode rn = rightInorderNext(right);
    
    while (ln != null && rn != null) {
      int tmpSum = ln.val + rn.val;
      if (tmpSum == target) return true;
      else if (tmpSum < target) ln = leftInorderNext(left);
      else rn = rightInorderNext(right);
    }

    return false;
  }

  private TreeNode leftInorderNext(Stack<TreeNode> stack) {
    if (stack.isEmpty()) return null;
    TreeNode result = stack.pop();
    if (result.right != null) pushLeft(stack, result.right);
    return result;
  }

  private TreeNode rightInorderNext(Stack<TreeNode> stack) {
    if (stack.isEmpty()) return null;
    TreeNode result = stack.pop();
    if (result.left != null) pushRight(stack, result.left);
    return result;
  }

  private void pushLeft(Stack<TreeNode> stack, TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }

  private void pushRight(Stack<TreeNode> stack, TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.right;
    }
  }
}
