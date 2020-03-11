// Implement Stack using Queues 用队列实现栈

@EASY
public class LC225 {}

class MyStack {
  Queue<Integer> q1;
  Queue<Integer> q2;
  
  public MyStack() {
    q1 = new LinkedList<>();
    q2 = new LinkedList<>();
  }
  
  public void push(int x) {
    q1.offer(x);
  }
  
  public int pop() {
    while (q1.size() > 1) {
      q2.offer(q1.poll());
    }

    int result = q1.poll();
    
    Queue<Integer> temp = q1;
    q1 = q2;
    q2 = temp;
    
    return result;
  }
  
  public int top() {
    int result = pop();
    q1.offer(result);
    return result;
  }
  
  public boolean empty() {
    return q1.isEmpty();
  }
}
