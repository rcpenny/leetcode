// Third Maximum Number 第三大的数

@EASY
public class LC414 {
  private long MIN = Long.MIN_VALUE;

  @Array
  public int thirdMax(int[] nums) {
    long larger = MIN;
    long middle = MIN;
    long smaller = MIN;

    for (int n : nums) {
      if (n > larger) {
        smaller = middle;
        middle = larger;
        larger = n;
      } 
			
			else if (n < larger && n > middle) {
        smaller = middle;
        middle = n;
      } 
			
			else if (n < middle && n > smaller) {
        smaller = n;
      }
    }

    return smaller == Long.MIN_VALUE ? (int) larger : (int) smaller;
  }
}
