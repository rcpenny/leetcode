// Range Sum Query 2D - Immutable 二维区域和检索 - 矩阵不可变

@MEDIUM
public class LC304 {
	private int[][] f = null;

	@PrefixSum
	public NumMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;

		int m = matrix.length;
		int n = matrix[0].length;

		f = new int[m + 1][n + 1];

		for (int r = 0; r < m; r++)
			for (int c = 0; c < n; c++)
				f[r + 1][c + 1] = f[r][c + 1] + f[r + 1][c] - f[r][c] + matrix[r][c];
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
			return f[row2 + 1][col2 + 1] - f[row1][col2 + 1] - f[row2 + 1][col1] + f[row1][col1];
	}
}
