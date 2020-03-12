// Target Sum 目标和

@MEDIUM
public class LC494 {

	@DFS
	public int findTargetSumWays(int[] nums, int target) {
		if (nums == null || nums.length == 0) return 0;
		return find(nums, 0, target);
	}
	
	private int find(int[] nums, int index, int target) {
		if (index == nums.length) return target == 0 ? 1 : 0;

		int leftWays = find(nums, index + 1, target + nums[index]);
		int rightWays = find(nums, index + 1, target - nums[index]);

		return leftWays + rightWays;
	}

	@DP
	@TODO
	public int findTargetSumWays(int[] nums, int target) {

	}
}
