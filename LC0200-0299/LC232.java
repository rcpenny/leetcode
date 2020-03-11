// Implement Queue using Stacks 用栈实现队列

@EASY
public class LC232 {}

class MyQueue {
  Stack<Integer> stack1;
  Stack<Integer> stack2;

  public MyQueue() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }
  
  public void push(int x) {
    stack1.push(x);
  }
  
  public int pop() {
    switchStack(stack1, stack2);
    int result = stack2.pop();
    switchStack(stack2, stack1);
    return result;
  }
  
  public int peek() {
    switchStack(stack1, stack2);
    int result = stack2.peek();
    switchStack(stack2, stack1);
    return result;
  }
  
  public boolean empty() {
    return stack1.isEmpty();
  }

  private void switchStack(Stack<Integer> s1, Stack<Integer> s2) {
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
  }
}

