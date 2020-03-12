// Word Break II 单词拆分 II

@HARD
public class LC140 {

	@DP
  public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		
		int n = s.length();
		boolean[] f = new boolean[n + 1];
		List<List<String>> memo = new ArrayList<>();

		f[0] = true;
		memo.add(new ArrayList<>());

		for (int i = 1; i <= n; i++) {
			memo.add(new ArrayList<>());

			for (int j = 0; j < i; j++) {
				String sub = s.substring(j, i);
				
				if (f[j] && dict.contains(sub)) {
					f[i] = true;
					
					if (j == 0) {
						memo.get(i).add(sub);
						continue;
					}

					for (String record : memo.get(j)) {
						memo.get(i).add(record + " " + sub);
					}
				}
			}
		}

		return memo.get(n);
	}


	@Backtracking("如果用memo也会MLE")
	public List<String> wordBreak2(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		List<String> result = new ArrayList<>();

		if (!canBreak(s, wordDict)) {
			return result;
		}

		helper(s, dict, 0, "", result);
		return result;
	}

	private void helper(String s, Set<String> dict, int start, String comb, List<String> result) {
		if (start == s.length()) {
			result.add(comb);
			return;
		}

		// could use boolean[] f to prune
		for (int i = start; i < s.length(); i++) {
			String sub = s.substring(start, i + 1);

			if (dict.contains(sub)) {
				helper(s, dict, i + 1, comb + (comb.length() == 0 ? "" : " ") + sub, result);
			}
		}
	}
	
	public boolean canBreak(String s, List<String> wordDict) {
		Set<String> dict =new HashSet<>(wordDict);

		int n = s.length();

		boolean[] f = new boolean[n + 1];
		f[0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}

		return f[n];
	}
}
