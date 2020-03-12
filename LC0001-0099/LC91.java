// Decode Ways 解码方法

@MEDIUM
public class LC91 {

  @DP
  public int numDecodings(String s) {
		if (s == null || s.length() == 0) return 0;

		char[] letters = s.toCharArray();
		int n = s.length();
		int[] f = new int[n + 1];

		f[0] = 1;

		for (int i = 1; i <= n; i++) {
			if (letters[i - 1] != '0') f[i] += f[i - 1];

			if (i > 1) {
				if (letters[i - 2] == '1' || (letters[i - 2] == '2' && letters[i - 1] <= '6'))
				  f[i] += f[i - 2];
			}
		}

		return f[n];
  }
}
