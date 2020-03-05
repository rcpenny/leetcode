// Sparse Matrix Multiplication 稀疏矩阵的乘法

@MEDIUM
public class LC311 {

	@Math
  public int[][] multiply(int[][] A, int[][] B) {
    int n = A.length;
    int m = B[0].length;
    int t = A[0].length;
    int[][] C = new int[n][m];

    List<List<Integer>> col = new ArrayList<>();
    for (int i = 0; i < t; i++) {
      col.add(new ArrayList<>());
      for (int j = 0; j < m; j++) {
        if (B[i][j] != 0) {
            col.get(i).add(j);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int k = 0; k < t; k++) {
        if (A[i][k] == 0) continue;

        for (int j: col.get(k))
          C[i][j] += A[i][k] * B[k][j];
      }
    }
    return C;
  }
}
