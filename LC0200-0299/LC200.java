// Number of Islands 岛屿数量

class Point {
  int x;
  int y;
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

@MEDIUM
public class LC200 {

	private char SEA = '0';
  private char ISLAND = '1';

  private int[] dx = {0, 1, 0, -1};
  private int[] dy = {-1, 0, 1, 0};

	int row;
	int col;

  @BFS
  public int numIslands(char[][] grid) {
		int islandsCount = 0;
    if (grid == null || grid.length == 0 || grid[0].length == 0) return islandsCount;

    row = grid.length;
    col = grid[0].length;

    for (int i = 0; i < row; i++)
      for (int j = 0; j < col; j++)
        if (grid[i][j] == ISLAND) {
          traverseIslands(grid, i, j);
          islandsCount++;
        }

    return islandsCount;
  }

  private void traverseIslands(char[][] grid, int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		grid[x][y] = SEA;
    queue.offer(new Point(x, y));

    while (!queue.isEmpty()) {
      Point coor = queue.poll();
      for (int i = 0; i < 4; i++) {
        Point adj = new Point(coor.x + dx[i], coor.y + dy[i]);
				if (!inBound(adj, grid)) continue;
					grid[adj.x][adj.y] = SEA;
          queue.offer(adj);
      }
    }
  }

  private boolean inBound(Point coor, char[][] grid) {
		return 0 <= coor.x && coor.x < row && 0 <= coor.y && coor.y < col
			&& grid[coor.x][coor.y] == ISLAND;
  }
}
