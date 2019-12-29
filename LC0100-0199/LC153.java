// Find Minimum in Rotated Sorted Array

@MEDIUM
@Microsoft
public class LC153 {

  @BinarySearch
  public int findMin(int[] nums) {
    int n = nums.length;
    int tail = nums[n - 1];

    int start = 0;
    int end = n - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] <= tail) end = mid;
      else start = mid;
    }

    return Math.min(nums[start], nums[end]);
  }
}