// Majority Element 多数元素

@EASY
public class LC169 {
  
  @BoyerMooreAlgorithm
  public int majorityElement(int[] nums) {
    int count = 0;
    int candidate = 0;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }

    return candidate;
  }
}
