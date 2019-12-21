// Find the Duplicate Number

// assume the array is read only
// use only constant, O(1) extra space
// runtime complexity should be less than O(n2).
// only one duplicate number in the array, but it could be repeated more than once.

@MEDIUM
@Microsoft
public class LC287 {

  @BinarySearch
  public int findDuplicate(int[] nums) {
    int start = 1;
    int end = nums.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (sameOrSmaller(mid, nums) <= mid) start = mid;
      else end = mid;
    }

    if (sameOrSmaller(start, nums) <= start) return end;
		return start;
  }

  private int sameOrSmaller(int n, int[] nums) {
    int count = 0;
    for (int num : nums)
      if (num <= n) count++;
    return count;
  }
}
