// Sqrt(x) x 的平方根

@EASY
public class LC69 {

  @BinarySearch
  public int mySqrt(int x) {
    if (x < 0)  throw new IllegalArgumentException();
    if (x <= 1)    return x;

    int start = 1, end = x;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (x / mid < mid)  end = mid;
      else if (x / mid > mid) start = mid;
      else end = mid;
    }

    if (end > x / end)  return start;
    return end;
  }
}