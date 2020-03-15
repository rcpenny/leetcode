// Max Area of Island 岛屿的最大面积

@MEIDIUM
public class LC695 {  
  private int[] dx = {0, 0, 1, -1};
  private int[] dy = {1, -1, 0, 0};
  
  private int m = 0;
  private int n = 0;
  
  public int maxAreaOfIsland(int[][] grid) {    
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    
    int maxArea = 0;
    
    m = grid.length;
    n = grid[0].length;
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) continue;
        int area = traverse(grid, i, j);
        maxArea = Math.max(area, maxArea);
      }
    }
    
    return maxArea;
  }
  
  private int traverse(int[][] grid, int x, int y) {
    int area = 0;
    
    Queue<Point> queue = new LinkedList<>();
    queue.offer(new Point(x, y));
    grid[x][y] = 0;
    area++;
    
    while (!queue.isEmpty()) {
      Point tmp = queue.poll();
      
      for (int i = 0; i < 4; i++) {
        Point adj = new Point(tmp.x + dx[i], tmp.y + dy[i]);
        if (inBound(adj.x, adj.y, m, n) && grid[adj.x][adj.y] == 1) {
          queue.offer(adj);
          grid[adj.x][adj.y] = 0;
          area++;
        }
      }
    }
    
    return area;
  }
  
  private boolean inBound(int x, int y, int m, int n) {
    return 0 <= x && x < m && 0 <= y && y < n;
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
