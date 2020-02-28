// Power of Two 2的幂

public class LC231 {

	@BitManipulation
	public boolean isPowerOfTwo(int n) {
    if (n <= 0) return false;

    while (n > 1) {
      if (n % 2 == 1) return false;
      n >>= 1;
    }

    return true;
  }
}
