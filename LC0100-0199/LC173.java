//  Binary Search Tree Iterator

@MEDIUM
class BSTIterator {

  Stack<TreeNode> stack;

  @IteratorDesign
  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    pushToStack(root, stack);
  }
  
  /** @return the next smallest number */
  public int next() {
    TreeNode peek = stack.pop();
    if (peek.right != null) {
      pushToStack(peek.right, stack);
    }
    return peek.val;
  }
  
  /** @return whether we have a next smallest number */
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
