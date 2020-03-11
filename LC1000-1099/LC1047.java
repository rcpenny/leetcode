// Remove All Adjacent Duplicates In String 删除字符串中的所有相邻重复项

@EASY
class LC1047 {
  
	@Stack
	public String removeDuplicates(String S) {
    Stack<Character> stack = new Stack<>();
    
    for (char c : S.toCharArray()) {
      if (!stack.isEmpty() && c == stack.peek()) stack.pop();
      else stack.push(c);
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) sb.append(stack.pop());
    sb = sb.reverse();

    return sb.toString();
  }
}
