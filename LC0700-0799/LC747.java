// Largest Number At Least Twice of Others 至少是其他数字两倍的最大数

@EASY
public class LC747 {
	
	@Array
	public int dominantIndex(int[] nums) {
    int max = Integer.MIN_VALUE;
    int maxIndex = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= max) continue;
      max = nums[i];
      maxIndex = i;
    }

    for (int i = 0; i < nums.length; i++) {
      if (i != maxIndex && nums[i] * 2 > max) return -1;
    }

    return maxIndex;
  }
}
