// Rotting Oranges 腐烂的橘子

@EASY
public class LC994 {
  int EMPTY = 0;
  int FRESH = 1;
  int ROTTEN = 2;

  int[] dx = {0, 0, 1, -1};
  int[] dy = {1, -1, 0, 0};

  int r;
  int c;

	@BFS
  public int orangesRotting(int[][] grid) {
    r = grid.length;
    c = grid[0].length;

    int freshOranges = 0;
    Queue<Point> rottenQueue = new LinkedList<>();
    
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (grid[i][j] == FRESH) freshOranges++;
        else if (grid[i][j] == ROTTEN) rottenQueue.offer(new Point(i, j));
      }
    }

    int days = 0;
    if (freshOranges == 0) return days;

    while (!rottenQueue.isEmpty()) {
      int size = rottenQueue.size();

      for (int i = 0; i < size; i++) {
        Point tmp = rottenQueue.poll();

        for (int j = 0; j < 4; j++) {
          int x = tmp.x + dx[j];
          int y = tmp.y + dy[j];
          if (inBound(x, y, r, c) && grid[x][y] == FRESH) {
            grid[x][y] = ROTTEN;
            rottenQueue.offer(new Point(x, y));
            freshOranges--;
          }
        }
      }
			
      days++;
    }

    return freshOranges == 0 ? days - 1 : -1;
  }

  private boolean inBound(int x, int y, int r, int c) {
    return 0 <= x && x < r && 0 <= y && y < c;
  }
}

class Point {
  int x;
  int y;

  Point (int x, int y) {
    this.x = x;
    this.y = y;
  }
}
