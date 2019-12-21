// Longest Increasing Subsequence

@MEDIUM
@Microsoft
public class LC300 {

  @DynamicProgramming
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int max = 1;

    int n = nums.length;
    int[] f = new int[n];

    for (int i = 1; i < n; i++) {
      f[i] = 1;

      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          f[i] = Math.max(f[i], f[j] + 1);
        }
      }

      max = Math.max(max, f[i]);
    }

    return max;
  }
}