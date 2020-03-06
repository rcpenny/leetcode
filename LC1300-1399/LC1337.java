// The K Weakest Rows in a Matrix 方阵中战斗力最弱的 K 行

@EASY
public class LC1337 {

	@BinarySearch
  public int[] kWeakestRows(int[][] mat, int k) {
    for (int i = 0; i < mat.length; i++) {
      int soldier = 0;
      for (int j = 0; j < mat[0].length; j++) {
        soldier += mat[i][j] == 1 ? 1 : 0;
      }
      mat[i][0] = soldier;
      mat[i][1] = i;
    }

    Arrays.sort(mat, (a, b) -> {
      if (a[0] != b[0]) return a[0] - b[0];
      return a[1] - b[1];
    });

    int[] weakest = new int[k];
    for (int i = 0; i < k; i++)
      weakest[i] = mat[i][1];
    
    return weakest;
  }
}
