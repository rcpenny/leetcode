// Find the Smallest Divisor Given a Threshold 使结果不超过阈值的最小除数

@MEDIUM
public class LC1283 {

  @BinarySearch
  public int smallestDivisor(int[] nums, int threshold) {
    int start = 1;
    int end = 1000000;

    while (start + 1 < end) {
      int mid = (start + end) / 2;
      int sum = divisionSum(nums, mid);

      if (sum > threshold) start = mid;
      else end = mid;
    }

    if (divisionSum(nums, start) <= threshold) return start;
    return end;
  }

  private int divisionSum(int[] nums, int divider) {
    int sum = 0;
    for (int num : nums) {
      if (num >= divider && num % divider == 0) sum += num / divider;
      else sum += (num / divider + 1);
    }
    return sum;
  }
}