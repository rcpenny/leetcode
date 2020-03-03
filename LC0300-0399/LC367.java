// Valid Perfect Square 有效的完全平方数

@EASY
public class LC367 {
	
	@BinarySearch
	public boolean isPerfectSquare(int num) {
    int start = 1;
    int end = num;
    
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (num / mid >= mid) start = mid;
      else if (num / mid < mid) end = mid;
    }
    
    return isSquare(num, start) || isSquare(num, end);
  }
  
  private boolean isSquare(int num, int candidate) {
    return (num % candidate == 0) && (num / candidate == candidate);
  }
}
