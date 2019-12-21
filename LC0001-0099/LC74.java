// Search a 2D Matrix

@MEDIUM
@Microsoft
public class LC74 {

  @BinarySearch
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int m = matrix.length;
    int n = matrix[0].length;

    if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
      return false;
    }

    int start = 0;
    int end = m * n - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      int val = matrix[mid / n][mid % n];

      if (val == target) return true;
      else if (val < target) start = mid;
      else end = mid;
    }

    if (matrix[start / n][start % n] == target || matrix[end / n][end % n] == target) {
      return true;
    }

    return false;
  }
}