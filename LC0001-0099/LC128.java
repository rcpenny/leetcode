// Longest Consecutive Sequence 最长连续序列

@HARD
public class LC128 {

  @HashSet
  UnionFind
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    Set<Integer> set = new HashSet<>();
    
    for (int n : nums) set.add(n);
    int longest = 1;

    for (int i = 0; i < nums.length; i++) {
      if (!set.contains(nums[i])) continue;

      int left = nums[i] - 1;
      int right = nums[i] + 1;
      int len = 1;

      while (set.contains(left)) {
        len++;
        set.remove(left--);
      }

      while (set.contains(right)) {
        len++;
        set.remove(right++);
      }

      longest = Math.max(longest, len);
    }

    return longest;
  }
}