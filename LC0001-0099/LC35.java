// Search Insert Position 搜索插入位置

@EASY
public class LC35 {

	@BinarySearch
	public int searchInsert(int[] nums, int target) {
		if (target <= nums[0]) return 0;
		if (target > nums[nums.length - 1]) return nums.length;

		int start = 0;
		int end = nums.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] < target) start = mid;
			else if (nums[mid] > target) end = mid;
			else return mid;
		}
		
		if (nums[start] == target) return start;
		return end;
	}
}
