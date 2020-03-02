// Search in Rotated Sorted Array 搜索旋转排序数组

@MEDIUM
public class LC33 {
  
  @BinarySearch
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;

    int start = 0;
    int end = nums.length - 1;

    int tail = nums[end];

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      
      if (nums[mid] == target) return mid;

      if (target > tail) {
        if (nums[mid] > target || nums[mid] <= tail) end = mid;
        else start = mid;
      }

      else {
        if (nums[mid] < target || nums[mid] > tail) start = mid;
        else end = mid;
      }
    }

    if (nums[start] == target) return start;
    if (nums[end] == target) return end;
    return -1;
  }
}