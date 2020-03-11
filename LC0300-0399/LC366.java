// Find Leaves of Binary Tree 寻找完全二叉树的叶子节点

@MEDIUM
public class LC366 {

  @BottomUp
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> leaves = new ArrayList<>();

    getReversedDepth(root, leaves);
    return leaves;
  }

  private int getReversedDepth(TreeNode node, List<List<Integer>> leaves) {
    if (node == null) return 0;

    int leftDepth = getReversedDepth(node.left, leaves);
    int rightDepth = getReversedDepth(node.right, leaves);

    int depthOfNode = Math.max(leftDepth, rightDepth) + 1;

    while (leaves.size() < depthOfNode) {
      leaves.add(new ArrayList<>());
    }
    
    leaves.get(depthOfNode - 1).add(node.val);

    return depthOfNode;
  }
}
