// Unique Paths 不同路径

@MEDIUM
public class LC62 {
  
  @DynamicProgramming
  public int uniquePaths(int m, int n) {
    int[] prev = new int[n];
    int[] curr = new int[n];

    for (int i = 0; i < n; i++) {
      prev[i] = 1;
    }

    for (int i = 1; i < m; i++) {
      curr[0] = 1;

      for (int j = 1; j < n; j++) {
        curr[j] = prev[j] + curr[j - 1];
      }

      prev = curr;
    }

    return prev[n - 1];
  }
}