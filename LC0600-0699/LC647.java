// Palindromic Substrings 回文子串

@MEDIUM
public class LC647 {
  
	@DP
	public int countPalindromicSubstrings(String str) {
    if (str == null) return 0;

    int n = str.length();
    if (n <= 1) return n;

    char[] c = str.toCharArray();
    boolean[][] f = new boolean[n][n];

    int i, j, len;

    // len = 1
    for (i = 0; i < n; i++)
      f[i][i] = true;
    
    // len = 2
    for (i = 0; i < n - 1; i++)
      f[i][i + 1] = c[i] == c[i + 1] ? true : false;

    for (len = 3; len <= n; len++) {
      for (i = 0; i <= n - len; i++) {
        j = i + len - 1;
        f[i][j] = f[i + 1][j - 1] && (c[i] == c[j]);
      }
    }

    int count = 0;
    for (i = 0; i < n; i++)
      for (j = 0; j < n; j++)
        if (f[i][j]) count++;
    
    return count;
  }
}
