// Maximum Average Subarray I 子数组最大平均数 I

@EASY
public class LC643 {

  @SlidingWindow
  public double findMaxAverage(int[] nums, int k) {
    int tmpSum = 0;

    for (int i = 0; i < k; i++)
      tmpSum += nums[i];
    
    double maxAvg = tmpSum * 1.0 / k;

    for (int i = k; i < nums.length; i++) {
      tmpSum -= nums[i - k];
      tmpSum += nums[i];
      maxAvg = Math.max(maxAvg, tmpSum * 1.0 / k);
    }

    return maxAvg;
  }
}
