// Pow(x, n) Pow(x, n)

@MEDIUM
public class LC50 {

  @BinarySearch
  public double myPow(double x, int n) {
    if (x == 0.0) return 0.0;
    if (n == 0) return 1.0;

    if (n < 0) x = 1 / x;
    n = 0 - n;

    double result = 1.0;
    double product = x;

    while (n != 0) {
      if (n % 2 != 0) result *= product;
      n /= 2;
      product *= product;
    }

    return result;
  }
}
