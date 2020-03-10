// Two Sum IV - Input is a BST 两数之和 IV - 输入 BST

@EASY
public class LC653 {
  boolean exist = false;
  Set<Integer> set;

	@RecursionTraversal
  public boolean findTarget(TreeNode root, int k) {
    set = new HashSet<>();
    traverse(root, k);
    return exist;
  }

  private void traverse(TreeNode node, int k) {
    if (exist || node == null) return;

    traverse(node.left, k);
    System.out.println(node.val);

    int comp = k - node.val;    
    if (set.contains(comp)) exist = true;
    set.add(node.val);

    traverse(node.right, k);
  }
}

// 其实此题目的是LC1214
