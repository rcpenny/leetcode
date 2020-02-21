// Binary Tree Postorder Traversal 二叉树的后序遍历

@HARD
public class LC145 {
	
	@Recursive
	public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traverse(root, result);
    return result;
  }

  private void  traverse(TreeNode node, List<Integer> result) {
    if (node == null) return;

    traverse(node.left, result);
    traverse(node.right, result);

    result.add(node.val);
  }

	/** 迭代解法本质上是在模拟递归，因为在递归的过程中使用了系统栈，所以在迭代的解法中常用Stack来模拟系统栈 */
	// https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian--2/
	@Iterative
	public List<Integer> postorderTraversal(TreeNode root) {

  }
}
