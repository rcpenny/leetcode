// Longest Univalue Path 最长同值路径

@EASY
public class LC687 {
  int result;

  public int longestUnivaluePath(TreeNode root) {
		result = 0;
		
		bottomUp(root);
		
		return result;
  }
  
  public int bottomUp(TreeNode node) {
    if (node == null) return 0;
    
    int left = bottomUp(node.left);
    int right = bottomUp(node.right);
    
    int arrowLeft = 0;
    int arrowRight = 0;

    if (node.left != null && node.left.val == node.val) {
      arrowLeft += left + 1;
    }
    
    if (node.right != null && node.right.val == node.val) {
      arrowRight += right + 1;
    }
    
    result = Math.max(result, arrowLeft + arrowRight);
    return Math.max(arrowLeft, arrowRight);
  }
}
