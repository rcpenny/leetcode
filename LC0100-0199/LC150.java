// Evaluate Reverse Polish Notation 逆波兰表达式求值

@MEDIUM
public class LC150 {

  @Stack
  public int evalRPN(String[] tokens) {
  
  Stack<Integer> numbers = new Stack<>();
  List<String> ops = Arrays.asList("+", "-", "*", "/");
  
  for (String t : tokens) {
    if (!ops.contains(t)) {
      numbers.push(Integer.valueOf(t));
    } else {
      int operand2 = numbers.pop();
      int operand1 = numbers.pop();
      
      if (t.equals("+")) {
        numbers.push(operand1 + operand2);
      }
      else if (t.equals("-")) {
        numbers.push(operand1 - operand2);
      }
      else if (t.equals("*")) {
        numbers.push(operand1 * operand2);
      }
      else if (t.equals("/")) {
        numbers.push(operand1 / operand2);
      }
    }
  }
  
  return numbers.pop();
  }
}
