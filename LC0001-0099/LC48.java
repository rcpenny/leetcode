// Rotate Image 旋转图像

@MEDIUM
public class LC48 {

	@Array
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}

		int n = matrix.length;

		for (int i = 0; i < n / 2; i++)
			for (int j = 0; j < n; j++)
				swap(matrix, i, j, n - i - 1, j);

		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++)
				swap(matrix, i, j, j, i);
	}

	private void swap(int[][] matrix, int a, int b, int x, int y) {
		int tmp = matrix[a][b];
		matrix[a][b] = matrix[x][y];
		matrix[x][y] = tmp;
	}
}
