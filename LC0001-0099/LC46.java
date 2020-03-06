// Permutations 全排列

@MEDIUM
public class LC46 {

	@Backtracking
  public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		if (nums == null) return results;

		boolean[] visited = new boolean[nums.length];		
		dfs(nums, visited, new ArrayList<Integer>(), results);

		return results;
	}

	private void dfs(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> results) {
	  if (list.size() == nums.length) {
			results.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) continue; // 进入递归的条件：这个位置的数字没被选过

			list.add(nums[i]);
			visited[i] = true;
			dfs(nums, visited, list, results);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}
}
