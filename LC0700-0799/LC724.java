// Find Pivot Index 寻找数组的中心索引

@EASY
public class LC724 {
	
	@Array
	public int pivotIndex(int[] nums) {
    int leftSum = 0;
    int sum = Arrays.stream(nums).sum();
  
    for (int i = 0; i < nums.length; i++) {
      if (leftSum == sum - leftSum - nums[i]) return i;
      leftSum += nums[i];
    }

    return -1;
  }
}
