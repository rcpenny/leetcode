// Baseball Game 棒球比赛

@EASY
public class LC682 {

	@Stack
  public int calPoints(String[] ops) {
    Stack<Integer> stack = new Stack<>();

    for (String op : ops) {
      if (op.equals("+") || op.equals("D") || op.equals("C")) calculate(stack, op);
      else stack.push(Integer.parseInt(op));
    }

    int result = 0;
    while (!stack.isEmpty()) result += stack.pop();
    return result;
  }

  private void calculate(Stack<Integer> stack, String op) {
    if (op.equals("+")) {
      int operand2 = stack.pop();
      int operand1 = stack.pop();
      stack.push(operand1);
      stack.push(operand2);
      stack.push(operand1 + operand2);
    } else if (op.equals("D")) {
      int operand1 = stack.pop();
      stack.push(operand1);
      stack.push(operand1 * 2);
    } else {
      stack.pop();
    }
  }
}
