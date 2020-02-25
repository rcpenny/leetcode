// Minimum Size Subarray Sum 长度最小的子数组

@MEDIUM
public class LC209 {

  @TwoPointers
  public int minSubArrayLen(int s, int[] nums) {
    int n = nums.length;
    int sum = 0;
    int len = Integer.MAX_VALUE;
    
    int slow = 0;

    for (int fast = 0; fast < n; fast++) {
      sum += nums[fast];
      while (sum >= s) {
        len = Math.min(len, fast - slow + 1);
        sum -= nums[slow++];
      }
    }

    return len != Integer.MAX_VALUE ? len : 0;
  }
}
