// Word Search  单词搜索

@MEDIUM
public class LC79 {
  boolean found = false;

  int[] dx = {0, 0, 1, -1};
  int[] dy = {1, -1, 0, 0};

  int m;
  int n;

  @Backtracking
  @DFS
  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return false;
    }

    m = board.length;
    n = board[0].length;

    boolean[][] visited = new boolean[m][n];

    char[] w = word.toCharArray();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == w[0]) {
          visited[i][j] = true;
          search(w, 1, i, j, visited, board);
          visited[i][j] = false;
        }

        if (found) return found;
      }
    }

    return found;
  }

  private void search(char[] word, int index, int x, int y, boolean[][] visited, char[][] board) {
    if (index == word.length) {
      found = true;
      return;
    }

    int next = word[index];
    int r = 0;
    int c = 0;

    for (int i = 0; i < 4; i++) {
      r = x + dx[i];
      c = y + dy[i];

      if (0 <= r && r < m && 0 <= c && c < n && board[r][c] == next && !visited[r][c]) {
        visited[r][c] = true;
        search(word, index + 1, r, c, visited, board);
        visited[r][c] = false;
      }
    }
  }
}
