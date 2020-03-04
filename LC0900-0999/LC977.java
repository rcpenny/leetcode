// Squares of a Sorted Array 有序数组的平方

@EASY
public class LC977 {
	
	@TwoPointers
	public int[] sortedSquares(int[] nums) {
    int[] square = new int[nums.length];

    for (int i = 0; i < nums.length; i++) nums[i] = Math.abs(nums[i]);

    int start = 0, end = nums.length - 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[start] > nums[end]) {
        square[nums.length - 1 - i] = nums[start] * nums[start];
        start++;
        continue;
      }
      square[nums.length - 1 - i] = nums[end] * nums[end];
      end--;
    }

    return square;
  }
}
