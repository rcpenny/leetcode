// Basic Calculator II 基本计算器 II

@MEDIUM
public class LC227 {

	@Stack
  public int calculate(String s) {
    if (s == null || s.length() == 0) return 0;
    
    Stack<Integer> stack = new Stack<>();
		
		// 第一个sign by default +
    char sign = '+';
    int number = 0;
		
		for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      
      if (Character.isDigit(c)) {
        number = number * 10 + c - '0';
      }
			
			// 最后一个字符，铁要扔进去计算。因为一定是number 不能再继续放在上个if里面判断了
			// 或者和1一样，出了loop再操作一波
      if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
        if (sign == '+') stack.push(number);
        if (sign == '-') stack.push(-number);
        
        if (sign == '*') stack.push(stack.pop() * number);
        if (sign == '/') stack.push(stack.pop() / number);
        
        sign = c;
        number = 0;
      }
    }
    
    int result = 0;
    for (int i : stack) result += i;
    
    return result;
  }

}
