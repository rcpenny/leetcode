// Paint House 粉刷房子

@EASY
public class LC256 {
	
	@DynamicProgramming
	public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0 || costs[0].length == 0) {
      return 0;
    }
    
    int n = costs.length;
    
    int[][] f = new int[n][3];
    
    f[0][0] = costs[0][0];
    f[0][1] = costs[0][1];
    f[0][2] = costs[0][2];

    int i, j, k;
    
    for (i = 1; i < n; i++) {
      
      for (j = 0; j < 3; j++) {
        f[i][j] = Integer.MAX_VALUE;
        
        for (k = 0; k < 3; k++) {
          if (j == k) continue;
          
          f[i][j] = Math.min(f[i][j], f[i - 1][k] + costs[i][j]);
        }
      }
    }
    
    return Math.min(Math.min(f[n - 1][0], f[n - 1][1]), f[n - 1][2]);
  }
}
