// Decode Ways

@MEDIUM
public class LC91 {

  @DynamicProgramming
  public int numDecodings(String s) {
		if (s == null || s.length() == 0) return 0;

		char[] array = s.toCharArray();
		int n = s.length();
		int[] f = new int[n + 1];

		f[0] = 1;

		for (int i = 1; i <= n; i++) {
			if (array[i - 1] != '0') {
				f[i] += f[i - 1];
			}

			if (i > 1) {
				if (array[i - 2] == '1' || (array[i - 2] == '2' && array[i - 1] <= '6'))
				  f[i] += f[i - 2];
			}
		}

		return f[n];
  }
}
