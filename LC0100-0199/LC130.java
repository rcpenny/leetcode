// Surrounded Regions 被围绕的区域

class Point {
  int x;
  int y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

@MEDIUM
public class LC130 {
	int m;
  int n;

  int[] dx = {1, -1, 0, 0};
  int[] dy = {0, 0, 1, -1};

	@BFS
	@TLE
  public void solve(char[][] board) {
    if (board == null || board.length <= 1 || board[0].length <= 1) return;

    m = board.length;
    n = board[0].length;

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1)
          if (board[i][j] == 'O')
            fillBoarderRegion(board, i, j);

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        board[i][j] = board[i][j] == 'B' ? 'O' : 'X';

  }

  private void fillBoarderRegion(char[][] board, int x, int y) {
    Queue<Point> queue = new LinkedList<>();
    queue.offer(new Point(x, y));

    while (!queue.isEmpty()) {
      Point tmp = queue.poll();
      board[tmp.x][tmp.y] = 'B';

      for (int i = 0; i < 4; i++) {
        Point adj = new Point(tmp.x + dx[i], tmp.y + dy[i]);
        if (inBound(adj.x, adj.y) && board[adj.x][adj.y] == 'O') {
          queue.offer(adj);
        }
      }
    }
  }

  private boolean inBound(int x, int y) {
    return 0 <= x && x < m && 0 <= y && y < n;
  }
}
