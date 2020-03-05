// Longest Palindromic Subsequence 最长回文子序列

@MEDIUM
public class LC516 {

	@DyanmicProgramming
  public int longestPalindromeSubseq(String ss) {
		char[] s = ss.toCharArray();
		int n = s.length;
		if (n <= 1) return n;

		int[][] f = new int[n][n];
		int i, j, len;

		for (i = 0; i < n; i++)
			f[i][i] = 1;

		for (i = 0; i < n - 1; i++)
			f[i][i + 1] = (s[i] == s[i + 1]) ? 2 : 1;

		for (len = 3; len <= n; len++) {
			for (i = 0; i <= n - len; i++) {
				j = i + len - 1;

				// case 1
				f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);

				// case 2
				int expand = s[i] == s[j] ? 2 : 0;
				f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + expand);
 			}
		}

		return f[0][n - 1];
	}
}
