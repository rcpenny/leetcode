// Unique Paths II 不同路径 II

@MEDIUM
public class LC63 {
  
  @DynamicProgramming
  public int uniquePathsWithObstacles(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    if (grid[0][0] == 1) return 0;
    grid[0][0] = 1;

    for (int i = 1; i < m; i++) {
      grid[i][0] = (grid[i][0] == 0 && grid[i - 1][0] == 1) ? 1 : 0;
    }
    for (int j = 1; j < n; j++) {
      grid[0][j] = (grid[0][j] == 0 && grid[0][j - 1] == 1) ? 1 : 0;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (grid[i][j] == 1) {
          grid[i][j] = 0;
        } else {
          grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
        }
      }
    }

    return grid[m - 1][n - 1];
  }
}