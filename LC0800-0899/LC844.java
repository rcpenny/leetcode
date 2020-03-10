// Backspace String Compare 比较含退格的字符串

@EASY
public class LC844 {
  
  @Stack
  public boolean backspaceCompare(String S, String T) {
    String s = getText(S);
    String t = getText(T);

    if (s == null && t == null) return true;
    if (s == null || t == null) return false;

    return s.equals(t);
  }

  private String getText(String s) {
    Stack<Character> stack = new Stack<>();
    
    for (char c : s.toCharArray()) {
      if (Character.isLetter(c)) {
        stack.push(c);
      } else if (!stack.isEmpty()) {
        stack.pop();
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.toString();
  }
}
