// Spiral Matrix 螺旋矩阵

@MEDIUM
public class LC54 {

  @Array
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();

    if (matrix == null || matrix.length == 0) return result;

    int m = matrix.length;
    int n = matrix[0].length;

    int x = 0;
    int y = 0;

    int i = 0;

    while (m > 1 && n > 1) {
      for (i = 1; i < n; i++) {
        result.add(matrix[x][y++]);
      }

      for (i = 1; i < m; i++) {
        result.add(matrix[x++][y]);
      }

      for (i = 1; i < n; i++) {
        result.add(matrix[x][y--]);
      }

      for (i = 1; i < m; i++) {
        result.add(matrix[x--][y]);
      }

      x++;
      y++;
      m -= 2;
      n -= 2;
    }

    if (m == 1) {
      for (i = 0; i < n; i++) result.add(matrix[x][y++]);
    } else if (n == 1) {
      for (i = 0; i < m; i++) result.add(matrix[x++][y]);
    }

    return result;
  }
}
