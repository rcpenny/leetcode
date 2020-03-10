// Binary Tree Pruning 二叉树剪枝

@MEDIUM
public class LC814 {

	@BottomUp
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) return null;

    TreeNode leftSubtree = pruneTree(root.left);
    TreeNode rightSubtree = pruneTree(root.right);

    root.left = leftSubtree;
    root.right = rightSubtree;
  
    if (root.left == null && root.right == null && root.val == 0) {
      return null;
    }

    return root;
  }
}
