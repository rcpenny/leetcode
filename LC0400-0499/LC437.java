// Path Sum III 路径总和 III

@EASY
public class LC437 {
  int count = 0;
  
	@Backtracking
  public int pathSum(TreeNode root, int sum) {
    traverse(root, new ArrayList<>(), sum);
    return count;
  }
  
  private void traverse(TreeNode node, List<Integer> path, int sum) {
    if (node == null) return;
    
    path.add(node.val);
    
    int tmpSum = 0;
    for (int i = path.size() - 1; i >= 0; i--) {
      tmpSum += path.get(i);
      if (tmpSum == sum) count++;
    }
    
    traverse(node.left, path, sum);
    traverse(node.right, path, sum);
    
    path.remove(path.size() - 1);
  }
}
