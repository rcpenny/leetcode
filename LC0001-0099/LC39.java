// Combination Sum 组合总和

@MEDIUM
public class LC39 {

	@DFS
	@Backtracking
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();

		backtrack(candidates, 0, target, new ArrayList<>(), result);

		return result;
	}
	
	private void backtrack(int[] candidates, int start, int target, List<Integer> comb, List<List<Integer>> result) {
		if (target <= 0 || start == candidates.length) {
			if (target == 0) result.add(new ArrayList<>(comb));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			int tmp = candidates[i];
			comb.add(tmp);
			backtrack(candidates, i, target - tmp, comb, result);
			comb.remove(comb.size() - 1);
		}
	}
}
