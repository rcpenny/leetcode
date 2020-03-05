// Target Sum 目标和

@MEDIUM
public class LC494 {
	private int ways = 0;
	
	// same as coin change 2
	@DFS
	@DynamicProgramming
	public int findTargetSumWays(int[] nums, int target) {
		if (nums == null || nums.length == 0) return ways;
	
		find(nums, 0, target, 0);
	
		return ways;
	}
	
	private void find(int[] nums, int index, int target, int sum) {
		if (sum ==  target && index == nums.length) ways++;
		if (index == nums.length) return;

		find(nums, index + 1, target, sum + nums[index]);
		find(nums, index + 1, target, sum - nums[index]);
	}
}
