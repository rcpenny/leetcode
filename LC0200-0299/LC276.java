// Paint Fence 栅栏涂色

@EASY
public class LC276 {

	@DP
	public int numWays(int n, int k) {
    if (n <= 0) return 0;
    if (n == 1) return k;
    if (n == 2) return k * k;
    
    int[] f = new int[n + 1];
    f[0] = 0;
    f[1] = k;
    f[2] = k * k;

    for (int i = 3; i < n + 1; i++)
      f[i] = f[i - 1] * (k - 1) + f[i - 2] * (k - 1);

    return f[n];
  }
}
