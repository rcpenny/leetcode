// Find Minimum in Rotated Sorted Array II

@MEDIUM
@Microsoft
public class LC154 {

  @BinarySearch
  public int findMin(int[] nums) {
    int n = nums.length;

    int tail = nums[n - 1];
    int head = nums[0];

    if (tail == head) {
      for (int i = 0; i < n - 1; i++) {
        if (nums[i + 1] < nums[i]) return nums[i + 1];
      }
      return tail;
    }

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