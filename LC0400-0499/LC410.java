// Split Array Largest Sum

@HARD
@Google
public class LC410 {

  @DynamicProgramming
  public int splitArray(int[] nums, int m) {
    int n = nums.length;

    // f[i][j] 定义为将 nums[0..i] 分成 j 份时能得到的最小的分割子数组最大值
    int[][] f = new int[n + 1][m + 1];
    int[] prefix = new int[n + 1];

    int i, j;

    for (i = 0; i <= n; i++) {
      for (j = 0; j <= m; j++) {
        f[i][j] = Integer.MAX_VALUE;
      }
    }

    for (i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] + nums[i];
    }

    f[0][0] = 0;

    for (i = 1; i <= n; i++) {
      for (j = 1; j <= m; j++) {
        for (int k = 0; k < i; k++) {
          f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], prefix[i] - prefix[k]));
        }
      }
    }

    return f[n][m];
  }


  @BinarySearch
	public int splitArray(int[] nums, int m) {
		long start = 0;
		long end = 0;

		for (int num : nums) {
			start = Math.max(start, num);
			end += num;
		}

		while (start + 1 < end) {
			long mid = start + (end - start) / 2;
			if (canSplit(nums, m, mid))
				start = mid;
			else
				end = mid;
		}

		if (canSplit(nums, m, end)) return (int) end;
		return (int) start;
	}

	private boolean canSplit(int[] nums, int m, long sum) {
		int tmpsum = 0;
		int i = 0;

		while (i < nums.length) {
			int tmp =  nums[i];
			if (tmp + tmpsum < sum) {
				tmpsum += tmp;
				i++;
			} else {
				tmpsum = 0;
				m--;
			}
		}

		return m <= 0;
	}
}
