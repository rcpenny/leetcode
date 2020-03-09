// Kth Smallest Element in a BST 二叉搜索树中第K小的元素

@MEDIUM
public class LC230 {

	@Tree
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    pushToStack(stack, root);

    while (k-- != 1) {
      TreeNode tmp = stack.pop();
      pushToStack(stack, tmp.right);
    }

    return stack.peek().val;
  }

  private void pushToStack(Stack<TreeNode> stack, TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}

/**
 * 思路：
 * 非递归 中序遍历二叉树 with pushToStack(stack, node);
 */
