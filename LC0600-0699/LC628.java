// Maximum Product of Three Numbers 三个数的最大乘积

@EASY
public class LC628 {

	@Array
	public int maximumProduct(int[] nums) {
    // neg1 is smallest neg value
    int neg1 = Integer.MAX_VALUE;
    int neg2 = Integer.MAX_VALUE;

    // pos1 is largest pos value
    int pos1 = Integer.MIN_VALUE;
    int pos2 = Integer.MIN_VALUE;
    int pos3 = Integer.MIN_VALUE;

    for (int n: nums) {
      if (n <= neg1) {
        neg2 = neg1;
        neg1 = n;
      } else if (n <= neg2) {
        neg2 = n;
      }

      if (n >= pos1) {
        pos3 = pos2;
        pos2 = pos1;
        pos1 = n;
      } else if (n >= pos2) {
        pos3 = pos2;
        pos2 = n;
      } else if (n >= pos3) {
        pos3 = n;
      }
    }

    return Math.max(neg1 * neg2 * pos1, pos1 * pos2 * pos3);
  }
}
