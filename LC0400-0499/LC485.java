// Max Consecutive Ones 最大连续1的个数

@EASY
public class LC485 {
	
	@Array
	public int findMaxConsecutiveOnes(int[] nums) {
    int count = 0;
    int max = 0;

    for (int num : nums) {
      if (num == 0) {
        count = 0;
        continue;
      }
      count++;
      max = Math.max(max, count);
    }

    return max;
  }
}
