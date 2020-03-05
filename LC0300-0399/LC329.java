// Longest Increasing Path in a Matrix 矩阵中的最长递增路径

@HARD
public class LC329 {

  int[] dx = {0, 0, 1, -1};
  int[] dy = {1, -1, 0, 0};

  int m;
  int n;

  @DFS
  @Memoization
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int longest = 1;

    m = matrix.length;
    n = matrix[0].length;

    int[][] memo = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int tmp = dfs(matrix, i, j, memo);
        longest = Math.max(tmp, longest);
      }
    }

    return longest;
  }

  private int dfs(int[][] matrix, int x, int y, int[][] memo) {
    if (memo[x][y] != 0) return memo[x][y];

    int path = 1;

    for (int i = 0; i < 4; i++) {
      int r = x + dx[i];
      int c = y + dy[i];

      if (r < 0 || r >= m || c < 0 || c >= n) continue;
      if (matrix[r][c] <= matrix[x][y]) continue;

      int tmp = 1 + dfs(matrix, r, c, memo);
      path = Math.max(tmp, path);
    }

    memo[x][y] = path;

    return path;
  }
}
