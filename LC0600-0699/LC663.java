// Equal Tree Partition 均匀树划分

@MEDIUM
public class LC663 {
  Stack<Integer> seen;

	@BottomUp
  public boolean checkEqualTree(TreeNode root) {
    seen = new Stack();
    int total = sum(root);

    seen.pop();
    if (total % 2 != 0) return false;

    for (int s : seen) {
      if (s == total / 2) return true;
    }

    return false;
  }

  public int sum(TreeNode node) {
    if (node == null) return 0;
    seen.push(sum(node.left) + sum(node.right) + node.val);
    return seen.peek();
  }
}
