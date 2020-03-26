// Lowest Common Ancestor of a Binary Tree 二叉树的最近公共祖先

@MEDIUM
@HighFreq
public class LC236 {

  @BottomUp
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) return root;

    return left != null ? left : right;
  }
}

// 思路：在bottom up向上收集的每条路径上，出现p或q则返回p或q，反之返回null
