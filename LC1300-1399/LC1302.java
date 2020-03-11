// Deepest Leaves Sum 层数最深叶子节点的和

@MEDIUM
public class LC1302 {

  int sum = 0;
  int deepest = 1;
  
  @TopDown
  public int deepestLeavesSum(TreeNode root) {
    topDown(root, 1);
    return sum;
  }

  public void topDown(TreeNode node, int curDepth) {
    if (node == null) return;

    if (curDepth == deepest) sum += node.val;
    
    if (curDepth > deepest) {
      deepest = curDepth;
      sum = 0;
      sum += node.val;
    }

    topDown(node.left, curDepth + 1);
    topDown(node.right, curDepth + 1);
  }
}
