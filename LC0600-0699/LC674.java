// Longest Continuous Increasing Subsequence 最长连续递增序列

@EASY
public class LC674 {

	@TwoPointers
	public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int longest = 1;
    int anchor = 0;

    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] <= nums[i-1]) anchor = i;
      longest = Math.max(longest, i - anchor + 1);
    }

    return longest;
  }
}
