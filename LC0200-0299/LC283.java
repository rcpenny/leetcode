// Move Zeros 移动零

@EASY
public class LC283 {

	@Array
	public void moveZeroes(int[] nums) {
		int countZeros = 0;

		for (int i : nums) {
			if (i == 0)
				countZeros++;
		
		int curIndex = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) continue;
			nums[curIndex] = nums[i];
			curIndex++;
		}
		
		for (int j = 0; j < countZeros; j++)
			nums[nums.length - 1 - j] = 0;
	}
}
