// Implement Stack using Queues 用队列实现栈

@EASY
public class LC255{}

class MyStack {
  Queue<Integer> queue1;
  Queue<Integer> queue2;
  
  public MyStack() {
    queue1 = new LinkedList<>();
    queue2 = new LinkedList<>();
  }
  
  public void push(int x) {
    queue1.offer(x);
  }
  
  public int pop() {
    while (queue1.size() > 1) {
      queue2.offer(queue1.poll());
    }

    int result = queue1.poll();
    
    Queue<Integer> temp = queue1;
    queue1 = queue2;
    queue2 = temp;
    
    return result;
  }
  
  public int top() {
    int result = pop();
    queue1.offer(result);
    return result;
  }
  
  public boolean empty() {
    return queue1.isEmpty();
  }
}
