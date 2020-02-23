// Game of Life 生命游戏

@MEDIUM
public class LC289 {
  private final int LIVE = 1;
  private final int DEAD = 0;

  private final int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
  private final int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};

  int row;
  int col;

  @Array
  public void gameOfLife(int[][] board) {
    row = board.length;
    col = board[0].length;

    int[][] status = new int[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int number = liveCellsNumber(board, i, j);
        if (board[i][j] == DEAD) {
          if (number == 3) status[i][j] = LIVE;
          continue;
        }

        if (number < 2 || number > 3) status[i][j] = DEAD;
        else status[i][j] = LIVE;
      }
    }

    // 更新board
    for (int i = 0; i < row; i++)
      for (int j = 0; j < col; j++)
        board[i][j] = status[i][j];
  }

  private int liveCellsNumber(int[][] board, int x, int y) {
    int liveCellsCount = 0;
    for (int i = 0; i < 8; i++) {
      int x_ = x + dx[i], y_ = y + dy[i];
      if (0 <= x_ && x_ < row && 0 <= y_ && y_ < col)
        if (board[x_][y_] == LIVE) liveCellsCount++;
    }
    return liveCellsCount;
  }
}