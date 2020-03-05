// Partition to K Equal Sum Subsets 划分为k个相等的子集

@MEDIUM
@TODO("add dp solution")
class LC698 {

	@DFS
  public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = Arrays.stream(nums).sum(); 
		if (sum % k != 0) return false;

		// 1. check if any number > target, return false
		// 2. sort nums decreasing, 

		boolean[] visited = new boolean[nums.length];

		return canSplit(nums, visited, 0, k, 0, sum / k);
	}

	private boolean canSplit(int[] nums, boolean[] visited, int start, int k, int sum, int target) {
		if (k == 1) return true; // 因为前面 k - 1个都符合 subset sum == target, 能走到1说明已经满足了

		// 这里start从0开始有点像permuations，寻找新的排列.
		if (sum == target) {
			return canSplit(nums, visited, 0, k - 1, 0, target);
		}
		
		// 寻找sum == target的路上只要有一个符合就可以return true了
		for (int i = start; i < nums.length; i++) {
			if (visited[i] || sum + nums[i] > target) continue;

			visited[i] = true;

			// start index used as i since it's sort of like a combination sum
			boolean canFindOneSubset = canSplit(nums, visited, i + 1, k, sum + nums[i], target);
			if (canFindOneSubset) {
				return true;
			}

			visited[i] = false;
		}

		// 这一层完全找不到
		return false;
	}
}
