// Surface Area of 3D Shapes 三维形体的表面积

@EASY
public class LC892 {
  int[] dx = {0, 1, 0, -1};
  int[] dy = {1, 0, -1, 0};

	@Array
	public int surfaceArea(int[][] grid) {
    int N = grid.length;
    int area = 0;

    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (grid[i][j] > 0) {
          area += 2;
          for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            int nv = 0;

            if (0 <= nx && nx < N && 0 <= ny && ny < N)
              nv = grid[nx][ny];

            area += Math.max(grid[i][j] - nv, 0);
          }
        }

    return area;
  }
}
