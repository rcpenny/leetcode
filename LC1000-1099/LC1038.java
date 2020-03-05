// Binary Search Tree to Greater Sum Tree 从二叉搜索树到更大和树

@MEDIUM
public class LC1038 {
	int curSum = 0;

	@TRAVERSAL
  public TreeNode bstToGst(TreeNode root) {
    traverse(root);
    return root;
  }

  private void traverse(TreeNode node) {
    if (node == null) return;
        
    traverse(node.right);
    
    curSum += node.val;
    node.val = curSum;

    traverse(node.left);
  }
}
