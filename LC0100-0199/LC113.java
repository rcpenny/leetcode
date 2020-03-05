// Path Sum II 路径总和 II

@MEDIUM
public class LC113 {

	@Backtracking
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    List<Integer> path = new ArrayList<>();
    path.add(root.val);

    find(root, sum, root.val, path, result);

    return result;
  }

  private void find(TreeNode node, int sum, int curSum, List<Integer> path, List<List<Integer>> result) {
    if (node.left == null && node.right == null) {
      if (curSum == sum) result.add(new ArrayList<>(path));
      return;
    }

    if (node.left != null) {
      path.add(node.left.val);
      find(node.left, sum, curSum + node.left.val, path, result);
      path.remove(path.size() - 1);
    }
    
    if (node.right != null) {
      path.add(node.right.val);
      find(node.right, sum, curSum + node.right.val, path, result);
      path.remove(path.size() - 1);
    }
  }
}
