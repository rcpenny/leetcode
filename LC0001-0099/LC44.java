// Wildcard Matching

@HARD
@Microsoft
public class LC44 {

  @DFS
  @Backtracking
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) return false;

    int m = s.length();
    int n = p.length();

    boolean[][] visited = new boolean[m][n];
    boolean[][] memo = new boolean[m][n];

    return matchHelper(s, 0, p, 0, visited, memo);
  }

  private boolean matchHelper(String s, int si, String p, int pi, boolean[][] visited, boolean[][] memo) {
    if (pi == p.length()) return si == s.length();
    if (si == s.length()) return starMatch(p, pi);

    if (visited[si][pi]) return memo[si][pi];

    char sc = s.charAt(si);
    char pc = p.charAt(pi);

    boolean match = false;

    if (pc == '*') {
      match = matchHelper(s, si + 1, p, pi, visited, memo) || matchHelper(s, si, p, pi + 1, visited, memo);
    } else {
      match = singleMatch(sc, pc) && matchHelper(s, si + 1, p, pi + 1, visited, memo);
    }

    visited[si][pi] = true;
    memo[si][pi] = false;

    return match;
  }

  private boolean singleMatch(char a, char b) {
    return a == b || b == '?';
  }

  private boolean starMatch(String p, int pi) {
    for (int i = pi; i < p.length(); i++) {
      if (p.charAt(i) != '*') return false;
    }
    return true;
  }
}