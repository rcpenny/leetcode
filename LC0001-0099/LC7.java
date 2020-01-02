// Reverse Integer

@EASY
public class LC7 {
  
  @Math
  public int reverse(int x) {
    if (x == 0) return 0;

    long y = 0;

    while (x % 10 == 0) {
      x /= 10;
    }

    while (x != 0) {
      y = y * 10 + x % 10;
      x /= 10;
    }

    if (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
      return 0;
    }

    return (int) y;
  }
}