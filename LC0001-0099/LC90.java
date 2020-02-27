// Subsets II 子集 II

public class L90 {

  @Backtracking
  public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		if (nums == null) return results;

		Arrays.sort(nums);
		dfs(nums, 0, new ArrayList<Integer>(), results);

		return results;
	}

	private void dfs(int[] nums, int start, List<Integer> subset, List<List<Integer>> results) {
		results.add(new ArrayList<>(subset));

		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) continue;
			subset.add(nums[i]);
			dfs(nums, i + 1, subset, results);
			subset.remove(subset.size() - 1);
		}
	}
}