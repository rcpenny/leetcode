// Convert BST to Greater Tree 把二叉搜索树转换为累加树

@EASY
public class LC538 {
  int sum = 0;

  @Tree
  public TreeNode convertBST(TreeNode root) {
    traverse(root);
    return root;
  }

  private void traverse(TreeNode node) {
    if (node == null) return;

    traverse(node.right);

    sum += node.val;
    node.val = sum;
    
    traverse(node.left);
  }
}