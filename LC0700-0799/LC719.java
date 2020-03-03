// Find K-th Smallest Pair Distance 找出第 k 小的距离对

@HARD
public class LC719 {
	
	// 二分答案
	@BinarySearch
	public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);

    int n = nums.length;

    int start = 0;
    int end = nums[n - 1];

    while (start < end) {
      int mid = start + (end -start) / 2;

      int count = 0;
      int index = 0;

      for (int i = 0; i < n; i++) {
        while (nums[i] - nums[index] > mid) index++;
        count += i - index;
      }

      if (count < k) start = mid + 1;
      else end = mid;
    }

    return start;
  }
}
