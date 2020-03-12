// Inorder Successor in BST 二叉搜索树中的顺序后继

@MEDIUM
public class LC285 {

  @BST
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) return null;

    if (root.val <= p.val) {
      return inorderSuccessor(root.right, p);
    }

    TreeNode result = inorderSuccessor(root.left, p);

    return result != null ? result : root;
  }
}
