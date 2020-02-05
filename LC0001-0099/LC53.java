// Maximum Subarray 最大子序和

@EASY
public class LC53 {

  @DynamicProgramming
  public int maxSubArray(int[] nums) {
    int prefix = 0;
    int curMin = 0;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      prefix += nums[i];
      max = Math.max(max, prefix - curMin);
      curMin = Math.min(curMin, prefix);
    }

    return max;
  }
}
