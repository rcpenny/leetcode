// Combination 组合

@MEDIUM
public class LC77 {

	@Backtracking
  public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<>();

		dfs(n, k, 1, new ArrayList<Integer>(), results);
		
		return results;
	}

	private void dfs(int n, int k, int start, List<Integer> comb, List<List<Integer>> results) {
		if (comb.size() == k) {
			results.add(new ArrayList<Integer>(comb));
			return;
		}

		for (int i = start; i <= n; i++) {
			comb.add(i);
			dfs(n, k, i + 1, comb, results);
			comb.remove(comb.size() - 1);
		}
	}

}
