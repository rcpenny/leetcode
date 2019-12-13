// Climbing Stairs

// n is positive integer

@EASY
public class LC70 {

	@DynamicProgramming
	public int climbStairs(int n) {
		if (n == 1) return 1;

		int[] f = new int[n + 1];

		f[1] = 1;
		f[2] = 2;

		for (int i = 3; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}

		return f[n];
	}

	// O(1) space
	public int climbStairs2(int n) {
		if (n <= 2) return n;

		int first = 1;
		int second = 2;
		int third = first + second;

		for (int i = 3; i <= n; i++) {
			third = first + second;
			first = second;
			second = third;
		}

		return third;
	}
}
