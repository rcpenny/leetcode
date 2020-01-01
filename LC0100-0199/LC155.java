// Min Stack

@EASY
@Google
public class LC155 {}

@Design
class MinStack {
  Stack<Integer> stack;
  Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int x) {
    if (stack.isEmpty()) {
      stack.push(x);
      minStack.push(x);
    } else {
      int curMin = getMin();
      stack.push(x);
      minStack.push(Math.min(curMin, x));
    }
  }
  
  public void pop() {
    stack.pop();
    minStack.pop();
  }
  
  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
