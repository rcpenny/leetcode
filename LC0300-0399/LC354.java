// Russian Doll Envelopes 俄罗斯套娃信封问题

@HARD
public class LC254 {

	@DynamicProgramming
	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		if (n == 0) return 0;
	
		Arrays.sort(envelopes, (a, b) -> {
			if (a[0] != b[0]) return a[0] - b[0];
			return a[1] - b[1];
		});

		int[] f = new int[n];

		int max_envelopes = 0;
		for (int i = 0; i < n; i++) {
			f[i] = 1;
			int[] current = envelopes[i];
			
			// 用二分法提升至nlogn, find last position of fit in envelopes
			// 这里是暴力循环所有前面的f[j]了
			for (int j = 0; j < i; j++) {
				int[] prev = envelopes[j];
				if (prev[0] < current[0] && prev[1] < current[1])
					f[i] = Math.max(f[i], f[j] + 1);
			}

			max_envelopes = Math.max(max_envelopes, f[i]);
		}

		return max_envelopes;
	}
}
