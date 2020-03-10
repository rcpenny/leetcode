// Binary Search Tree Iterator 二叉搜索树迭代器

@MEDIUM
class BSTIterator {
  Stack<TreeNode> stack;

  @Iterator
  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    pushToStack(root, stack);
  }
  
  public int next() {
    TreeNode peek = stack.pop();
    if (peek.right != null) {
      pushToStack(peek.right, stack);
    }
    return peek.val;
  }
  
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  private void pushToStack(TreeNode node, Stack<TreeNode> stack) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}
