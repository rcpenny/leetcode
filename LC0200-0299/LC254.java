// Factor Combinations 因子的组合

@MEDIUM
public class LC254 {

	@Backtracking
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();

		factorize(n, 2, new ArrayList<>(), result);
		
		return result;
	}

	private void factorize(int n, int start, List<Integer> comb, List<List<Integer>> result) {
		if (n <= 1) {
			// 避免n的情况 8 -> [8]
			if (comb.size() > 1)
				result.add(new ArrayList<>(comb));
			return;
		}

		for (int i = start; i <= n; i++) {
			if (n % i != 0) continue;

			comb.add(i);
			factorize(n / i, i, comb, result);
			comb.remove(comb.size() - 1);
		}
	}
}
