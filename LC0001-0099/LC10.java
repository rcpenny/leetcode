// Regular Expression Matching

// Input:
// s = "mississippi"
// p = "mis*is*p*."
// Output: false

@HARD
@Microsoft
public class LC10 {

  @DynamicProgramming
  public boolean isMatch(String A, String B) {
		char[] s = A.toCharArray();
		char[] p = B.toCharArray();

		int m = s.length;
		int n = p.length;

		boolean[][] f = new boolean[m + 1][n + 1];
		int i, j;

		for (i = 0; i <= m; i++) {
			for (j = 0; j <= n; j++) {
				if (i == 0 && j == 0) {
					f[i][j] = true;
					continue;
				}

				if (j == 0) {
					f[i][j] = false;
					continue;
				}

				if (p[j - 1] != '*') {
					if (i > 0 && (p[j - 1] == '.' || p[j - 1] == s[i - 1])) {
						f[i][j] = f[i - 1][j - 1];
					}
				} else {
					if (j > 1) {
						f[i][j] = f[i][j - 2];
					}

					if (i > 0 && j > 1 && p[j - 2] == '.' || p[j - 2] == s[i - 1]) {
						f[i][j] = f[i][j] || f[i - 1][j];
					}
				}
			}
		}

		return f[m][n];
  }
}