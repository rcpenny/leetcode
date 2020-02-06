// Walls and Gates 墙与门

@MEDIUM
public class LC286 {

  @BFS
  public void wallsAndGates(int[][] rooms) {
    int n = rooms.length;
    if (n == 0) return;
    int m = rooms[0].length;
    
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};
    
    Queue<Integer> qx = new LinkedList<>();
    Queue<Integer> qy = new LinkedList<>();
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (rooms[i][j] == 0) {
          qx.offer(i);
          qy.offer(j);
        }
      }
    }
    
    while (!qx.isEmpty()) {
      int cx = qx.poll();
      int cy = qy.poll();
      
      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        
        if (0 <= nx && nx < n && 0 <= ny && ny < m && rooms[nx][ny] == Integer.MAX_VALUE) {
          rooms[nx][ny] = rooms[cx][cy] + 1;
          qx.offer(nx);
          qy.offer(ny);
        }
      }
    }
  }
}