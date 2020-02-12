// Maximum Width Ramp 最大宽度坡

@MEDIUM
public class LC962 {

  @MonotonicStack
  public int maxWidthRamp(int[] A) {    
    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    for (int i = 1; i < A.length; i++) {
      if (A[i] <= A[stack.peek()]) {
        stack.push(i);
      }
    }

    int max = 0;

    for (int i = A.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
        max = Math.max(max, i - stack.pop());
      }
    }

    return max;
  }
}
