// Binary Search 二分查找

@EASY
public class LC704 {

  @BinarySearch
  public int search(int[] nums, int target) {
    int n = nums.length;

    if (target < nums[0] || target > nums[n - 1]) return -1;

    int start = 0;
    int end = n - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;

      if (nums[mid] == target) return mid;
      if (nums[mid] < target) start = mid;
      else end = mid;
    }

    if (nums[start] == target) return start;
    if (nums[end] == target) return end;
    return -1;
  }
}
