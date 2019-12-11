// Search a 2D Matrix II

@MEDIUM
public class LC240 {

  @DivideConquer
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int m = matrix.length;
    int n = matrix[0].length;

    if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
      return false;
    }

    int row = m - 1;
    int col = 0;

    while (row >= 0 && col < n) {
      int val = matrix[row][col];

      if (val == target) return true;
      else if (val < target) col++;
      else row--;
    }

    return false;
  }
}