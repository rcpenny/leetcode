// Subtree of Another Tree 另一个树的子树

@EASY
@HighFreq
public class LC572 {

	@Tree
	public boolean isSubtree(TreeNode s, TreeNode t) {
    if (sameTree(s, t)) return true;

    boolean left = s.left != null ? isSubtree(s.left, t) : false;
    boolean right = s.right != null ? isSubtree(s.right, t) : false;

    return left || right;
  }

  private boolean sameTree(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;

    return a.val == b.val && sameTree(a.left, b.left) && sameTree(a.right, b.right);
  }
}
