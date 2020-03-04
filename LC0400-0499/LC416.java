// Partition Equal Subset Sum 分割等和子集

@MEDIUM
public class LC416 {

	@DynamicProgramming
	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length < 2) return false;

    int sum = Arrays.stream(nums).sum();
		if (sum % 2 != 0) return false;

		int n = nums.length;
		int target = sum / 2;

		boolean[][] f = new boolean[n + 1][target + 1];

		// 前0个数字可以拼出和为0
		f[0][0] = true; 

		// 前0个数字不能拼出和为j(j > 0) 
		for (int j = 1; j <= target; j++) {
			f[0][j] = false; 
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= target; j++) {
				f[i][j] = false;

				if (f[i - 1][j] == true) {
					f[i][j] = true;
					continue;
				}

				if (j - nums[i - 1] >= 0 && f[i - 1][j - nums[i - 1]] == true) {
					f[i][j] = true;
				}
			}
		}

		for (int i = 1; i <= n; i++)
			if (f[i][target] == true)
				return true;
		
		return false;
	}
}
