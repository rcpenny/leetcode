// Single Number 只出现一次的数字

@EASY
public class LC136 {
  // rule 1: a ^ 0 = a
  // rule 2: a ^ a = 0

  @BitManipulation
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }

    return result;
  }
}
