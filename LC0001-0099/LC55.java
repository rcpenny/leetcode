// Jump Game

// [3,2,1,0,4] 输出: false

@MEDIUM
public class LC55 {

	@Greedy
	public boolean canJump(int[] nums) {
		int furthest = nums[0];
		int i = 0;

		while (i <= furthest) {
			furthest = Math.max(furthest, i + nums[i]);
			if (furthest >= nums.length - 1) return true;
			i++;
		}

		return false;
	}

	@DynamicProgramming
	public boolean canJump1(int[] nums) {
		int n = nums.length;

		boolean[] f = new boolean[n];
		f[0] = true;

		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (f[j] && j + nums[j] >= i) {
					f[i] = true;
					break;
				}
			}
		}

		return f[n - 1];
	}
}
