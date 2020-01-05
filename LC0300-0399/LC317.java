// Shortest Distance from All Buildings

@HARD
public class LC317 {
  final int EMPTY = 0;
  final int BUILDING = 1;
  final int BLOCK = 2;

  int[] dx = {0, 0, 1, -1};
  int[] dy = {1, -1, 0, 0};

  int m;
  int n;

  @BFS
  public int shortestDistance(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
    
    m = grid.length;
    n = grid[0].length;
    
    int[][] distanceSum = new int[m][n]; // 所有房子到此Empty点的距离
    int[][] reach = new int[m][n];       // 这个Empty点 能reach到房子的数量

    int buildingNumber = 0;
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (grid[i][j] == BUILDING) buildingNumber++;

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
				if (grid[i][j] == BUILDING)
					bfs(grid, i, j, distanceSum, reach);

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
				if (grid[i][j] == EMPTY && reach[i][j] == buildingNumber)
					result = Math.min(result, distanceSum[i][j]); 

    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private void bfs(int[][] grid, int x, int y, int[][] distanceSum, int[][] reach) {
    int steps = 0;
    boolean[][] visited = new boolean[m][n];

    Queue<Point> queue = new LinkedList<>();
    queue.offer(new Point(x, y));
    
    while (!queue.isEmpty()) {
      int size = queue.size();
      steps++;
      for (int i = 0; i < size; i++) {
        Point p = queue.poll();
        for (int j = 0; j < 4; j++) {
          Point adj = new Point(p.x + dx[j], p.y + dy[j]);
          if (!canMove(adj, grid, visited)) continue;
          visited[adj.x][adj.y] = true;
          distanceSum[adj.x][adj.y] += steps;
          reach[adj.x][adj.y]++;
          queue.offer(adj);
        }
      }
    }
    return;
  }

  private boolean canMove(Point p, int[][] grid, boolean[][] visited) {
    return 0 <= p.x && p.x < m && 0 <= p.y && p.y < n 
      && grid[p.x][p.y] != BLOCK && grid[p.x][p.y] != BUILDING && !visited[p.x][p.y];
  }
}

class Point {
  int x;
  int y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
