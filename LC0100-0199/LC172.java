// Trailing Zeros 阶乘后的零

@EASY
public class LC172 {

	@Math
  public int trailingZeroes(int n) {
    int result = 0;

    while (n != 0) {
      result += n / 5;
      n /= 5;
    }

    return result;
  }
}
