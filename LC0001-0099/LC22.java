// Generate Parentheses

@MEDIUM
public class LC22 {
  
  @DFS
  @Backtracking
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    if (n <= 0) return result;

    generate(n, 0, 0, new StringBuilder(), result);

    return result;
  }

  private void generate(int n, int leftUsed, int rightUsed, StringBuilder sb, List<String> result) {
    if (sb.length() == n * 2) {
      result.add(sb.toString());
      return;
    }

    if (leftUsed < n) {
      sb.append('(');
      generate(n, leftUsed + 1, rightUsed, sb, result);
      sb.deleteCharAt(sb.length() - 1);
    }

    if (rightUsed < leftUsed) {
      sb.append(')');
      generate(n, leftUsed, rightUsed + 1, sb, result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}