// Unique Paths 不同路径

@MEDIUM
public class LC62 {
  
	// 滚动数组
  @DP
  public int uniquePaths(int m, int n) {
    int[] prevRow = new int[n];
    int[] currRow = new int[n];

    for (int i = 0; i < n; i++) {
      prevRow[i] = 1;
    }

    for (int i = 1; i < m; i++) {
      currRow[0] = 1;

      for (int j = 1; j < n; j++) {
        currRow[j] = prevRow[j] + currRow[j - 1];
      }

      prevRow = currRow;
    }

    return prevRow[n - 1];
  }
}
