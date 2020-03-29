// Find Mode in Binary Search Tree 二叉搜索树中的众数

@EASY
public class LC501 {
	int maxFreq = 0;

	@Traversal
  public int[] findMode(TreeNode root) {
    Map<Integer, Integer> freq = new HashMap<>();
    inorder(root, freq);

    List<Integer> list = new ArrayList<>();
    for (int key : freq.keySet()) {
      if (freq.get(key) == maxFreq) list.add(key);
    }

    int[] result = new int[list.size()]; 
    for (int i = 0; i < list.size(); i++) result[i] = list.get(i);

    return result;
  }

  private void inorder(TreeNode node, Map<Integer, Integer> freq) {
    if (node == null) return;

    inorder(node.left, freq);

    if (!freq.containsKey(node.val)) {
      freq.put(node.val, 1);
      maxFreq = Math.max(maxFreq, 1);
    } else {
      int curFreq = freq.get(node.val);
      freq.put(node.val, ++curFreq);
      maxFreq = Math.max(maxFreq, curFreq);
    }

    inorder(node.right, freq);
  }
}
