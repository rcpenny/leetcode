// Remove Outermost Parentheses 删除最外层的括号

@EASY
public class LC1021 {
  public String removeOuterParentheses(String S) {
    StringBuilder sb = new StringBuilder();

    int flag = 0;
  
    for (char c : S.toCharArray()) {
      if (c == ')') flag--;
      if (flag >= 1) sb.append(c);
      if (c == '(') flag++;
    }

    return sb.toString();
  }
}
