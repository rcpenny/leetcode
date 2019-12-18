// Word Break

@MEDIUM
public class LC139 {

	@DynamicProgramming
	public boolean wordBreak(String s, List<String> wordDict) {
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
