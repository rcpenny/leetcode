// Count Negative Numbers in a Sorted Matrix 统计有序矩阵中的负数

@EASY
public class LC1351 {
	
	@Array
	public int countNegatives(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int count = 0;
    int negIndex = n - 1;

    for (int i = 0; i < m; i++) { 
      if (negIndex == n - 1 && grid[i][negIndex] >= 0) continue;

      for (int j = negIndex; j >= 0; j--) {
        if (grid[i][j] >= 0) {
          negIndex = j + 1;
          break;
        }
        if (j == 0) negIndex = 0;
      }
      count += (n - negIndex);
    }

    return count;
  }
}
