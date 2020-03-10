// Most Frequent Subtree Sum 出现次数最多的子树元素和

@MEDIUM
public class LC508 {

	@BottomUp
  public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> freq = new HashMap<>();

    bottomUp(root, freq);

    int maxFreq = 0;
    int maxCount = 0;
    for (int key : freq.keySet()) {
      if (freq.get(key) > maxFreq) {
        maxFreq = freq.get(key);
        maxCount = 1;
      } else if (freq.get(key) == maxFreq) {
        maxCount++;
      }
    }

    int[] result = new int[maxCount];
    int index = 0;
    for (int key : freq.keySet()) {
      if (freq.get(key) == maxFreq) result[index++] = key;
    }

    return result;
  }

  private int bottomUp(TreeNode node, Map<Integer, Integer> freq) {
    if (node == null) return 0;

    int leftSum = bottomUp(node.left, freq);
    int rightSum = bottomUp(node.right, freq);

    int sum = leftSum + rightSum + node.val;
    freq.put(sum, freq.getOrDefault(sum, 0) + 1);

    return sum;
  }

}
