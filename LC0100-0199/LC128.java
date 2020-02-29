// Longest Consecutive Sequence 最长连续序列

@HARD
public class LC128 {
	
	@Array
	@HashSet
	public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int max = 1;

    Set<Integer> set = new HashSet<>();
    for (int n : nums) set.add(n);

    for (int n : nums) {
      if (!set.contains(n)) continue;
      set.remove(n);
      max = Math.max(max, longestConsec(set, n));
    }

    return max;
  }

  private int longestConsec(Set<Integer> set, int number) {
    int len = 1;
    int left = number - 1;
    int right = number + 1;

    while (set.contains(left)) {
      len++;
      set.remove(left);
      left--;
    }

    while (set.contains(right)) {
      len++;
      set.remove(right);
      right++;
    }

    return len;
  }
}
