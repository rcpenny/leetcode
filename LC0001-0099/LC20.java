// Valid Parentheses

@EASY
public class LC20 {

  @StackDesign
  public boolean isValid(String s) {
    if (s == null) return false;

    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (char c : chars) {
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) return false;
        
        if (c == ')' && stack.peek() != '(') return false;
        if (c == ']' && stack.peek() != '[') return false;
        if (c == '}' && stack.peek() != '{') return false;

        stack.pop();
      }
    }

    return stack.isEmpty();
  }
}