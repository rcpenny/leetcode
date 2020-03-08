// Combination Sum II 组合总和 II

@MEDIUM
public class LC40 {

	@Backtracking
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);

		search(candidates, 0, target, new ArrayList<>(), result);

		return result;
	}

	private void search(int[] candidates, int index, int target, 
			List<Integer> comb, List<List<Integer>> result) {
		if (target == 0) result.add(new ArrayList<>(comb));
		if (target <= 0) return;

		for (int i = index; i < candidates.length; i++) {
			if (i > index && candidates[i] == candidates[i - 1]) continue;

			comb.add(candidates[i]);
			search(candidates, i + 1, target - candidates[i], comb, result);
			comb.remove(comb.size() - 1);
		}
	}
}
