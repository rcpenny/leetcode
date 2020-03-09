// Minimum Distance Between BST Nodes 二叉搜索树结点最小距离

@EASY
public class LC783 {

	@IterativeTraversal
  public int minDiffInBST(TreeNode root) {
    int minDiff = Integer.MAX_VALUE;

    Stack<TreeNode> stack = new Stack<>();
    pushToStack(stack, root);

    while (!stack.isEmpty()) {
      TreeNode tmp = stack.pop();
      pushToStack(stack, tmp.right);

      if (!stack.isEmpty()) {
        minDiff = Math.min(minDiff, stack.peek().val - tmp.val);
      }
    }

    return minDiff;
  }

  private void pushToStack(Stack<TreeNode> stack, TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}
