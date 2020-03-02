// Guess Number Higher or Lower 猜数字大小

@EASY
public class LC374{}

public class Solution extends GuessGame {

  @BinarySearch
  public int guessNumber(int n) {
    int start = 1;
    int end = n;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (guess(mid) == 0) return mid;
      else if (guess(mid) == -1) end = mid;
      else start = mid;
    }

    return guess(start) == 0 ? start : end;
  }
}
