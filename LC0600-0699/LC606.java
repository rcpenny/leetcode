// Construct String from Binary Tree 根据二叉树创建字符串

@EASY
public class LC606 {

	@Recursive
  public String tree2str(TreeNode t) {
    if (t == null) return "";
    
    if (t.left == null && t.right == null) return t.val + "";
    
    if (t.right == null) return t.val + "(" + tree2str(t.left) + ")";
    return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right)+")"; 
  }
}
