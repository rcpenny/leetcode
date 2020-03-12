// Domino and Tromino Tiling 多米诺和托米诺平铺

@MEDIUM
class Solution {
  
	@DP
	public int numTilings(int N) {
    if (N < 3) return N;
    
    final long MOD = 1000000007;
    
    long[][] f = new long[N + 1][3];
    f[0][0] = f[1][0] = f[1][1] = f[1][2] = 1;
    
    for (int i = 2; i <= N; i++) {
        f[i][0] = (f[i - 1][0] + f[i - 2][0] + f[i - 2][1] + f[i - 2][2]) % MOD;
        f[i][1] = (f[i - 1][0] + f[i - 1][2]) % MOD;
        f[i][2] = (f[i - 1][0] + f[i - 1][1]) % MOD;
    }
    
    return (int)f[N][0];
  }
}
