// Basic Calculator 基本计算器

@HARD
public class LC224 {

	@Stack
	public int calculate(String s) {
		Stack<Integer> numbers = new Stack<Integer>();
		Stack<Integer> signs = new Stack<>();

		int result = 0; // For the on-going result
		int operand = 0;
		int sign = 1;  // 1 means positive, -1 means negative/multi???

		// 第一个sign by default是 +
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				operand = 10 * operand + (ch - '0');
			} 
			
			else if (ch == '+') {
				result = result + sign * operand;
				sign = 1;
				operand = 0;
			} 
			
			else if (ch == '-') {
				result = result + sign * operand;
				sign = -1;
				operand = 0;
			} 
			
			// 碰到(, numbers加入之前的运行结果, signs加入(前的运算符
			// result, sign清零 ，开启这个()中的运算
			else if (ch == '(') {
				numbers.push(result);
				signs.push(sign);
				result = 0;
				sign = 1;
			} 
			
			// 结束这个()中的运算，
			else if (ch == ')') {
				result = result + sign * operand;
				result = result * signs.pop();
				result = result + numbers.pop();
				operand = 0;
			}
		}
		return result + (sign * operand);
	}
}
