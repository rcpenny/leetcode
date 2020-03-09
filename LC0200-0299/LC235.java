// Lowest Common Ancestor of a Binary Search Tree 二叉搜索树的最近公共祖先

@EASY
class LC235 {

  @TopDown
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val > p.val && root.val > q.val)
      return lowestCommonAncestor(root.left, p, q);

    if (root.val < p.val && root.val < q.val)
      return lowestCommonAncestor(root.right, p, q);

    return root;
  }
}

/**
 * 思路：
 * ancestor一定是介于pq之间的值，根据BST性质左右摇摆
 */
