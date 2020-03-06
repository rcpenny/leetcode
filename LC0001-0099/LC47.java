// Permutations II 全排列 II

@MEDIUM
public class LC47 {

	@Backtracking
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		if (nums == null) return results;

		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		
		dfs(nums, visited, new ArrayList<Integer>(), results);

		return results;
	}

	private void dfs(int[] nums, boolean[] visited, List<Integer> permute, List<List<Integer>> results) {
		if (permute.size() == nums.length) {
			results.add(new ArrayList<>(permute));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) continue; // 进入递归的条件：这个位置的数字没被选过 && 去重
			if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

			permute.add(nums[i]);
			visited[i] = true;
			dfs(nums, visited, permute, results);
			permute.remove(permute.size() - 1);
			visited[i] = false;
		}
	}
}
