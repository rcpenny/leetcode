// Flood Fill	图像渲染

@EASY
public class LC733 {
  int originColor;

  int m;
  int n;

  int[] dx = {0, 0, 1, -1};
  int[] dy = {1, -1, 0, 0};

  @BFS
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0 || image[0].length == 0) {
      return image;
    }

    originColor = image[sr][sc];
    if (originColor == newColor) return image;

    m = image.length;
    n = image[0].length;

    Queue<Point> queue = new LinkedList<>();
    queue.offer(new Point(sr, sc));

    while (!queue.isEmpty()) {
      Point tmp = queue.poll();

      int x = tmp.x;
      int y = tmp.y;

      if (image[x][y] == originColor) {
        image[x][y] = newColor;
      }

      for (int i = 0; i < 4; i++) {
        int x_ = x + dx[i];
        int y_ = y + dy[i];
        if (x_ >= 0 && x_ < m && y_ >= 0 && y_ < n && image[x_][y_] == originColor) {
          queue.offer(new Point(x_, y_));
        }
      }
    }

    return image;
  }

  class Point {
    int x;
    int y;
  
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
