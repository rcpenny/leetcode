// Search in Rotated Sorted Array II 搜索旋转排序数组 II

@MEDIUM
public class LC81 {

	@BinarySearch
	public boolean search(int[] nums, int target) {
    for (int n : nums)
      if (n == target) return true;
    return false;
  }
}
