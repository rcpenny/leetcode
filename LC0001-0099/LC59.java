// Spiral Matrix II 螺旋矩阵 II

@MEDIUM
public class LC59 {

	@Array
  public int[][] generateMatrix(int n) {
		if (n < 1) return new int[0][0];

		int[][] matrix = new int[n][n];
		int x = 0, y = 0, i = 0;
		int count = 1;
		int len = n;

		while (len > 0) {
			for (i = 0; i < len - 1; i++) {
				matrix[x][y++] = count;
				count++;
			}

			for (i = 0; i < len - 1; i++) {
				matrix[x++][y] = count;
				count++;
			}

			for (i = 0; i < len - 1; i++) {
				matrix[x][y--] = count;
				count++;
			}

			for (i = 0; i < len - 1; i++) {
				matrix[x--][y] = count;
				count++;
			}

			x++;
			y++;
			len -= 2;
		}

		if (n % 2 != 0) matrix[n/2][n/2] = count;

		return matrix;
  }
}
