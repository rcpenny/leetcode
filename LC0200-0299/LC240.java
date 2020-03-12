// Search a 2D Matrix II 搜索二维矩阵 II

@MEDIUM
public class LC240 {

  @BinarySearch
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int row = matrix.length;
    int col = matrix[0].length;

    if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
      return false;
    }

    int m = row - 1;
    int n = 0;

    while (m >= 0 && n < col) {
      int val = matrix[m][n];

      if (val == target) return true;
      else if (val < target) n++;
      else m--;
    }

    return false;
  }
}
