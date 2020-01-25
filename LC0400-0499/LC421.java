// Maximum XOR of Two Numbers in an Array 数组中两个数的最大异或值

@MEDIUM
public class LC421 {

  @BitManipulation
  public int findMaximumXOR(int[] nums) {
    int max = 0;

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        max = Math.max(max, nums[i] ^ nums[j]);
      }
    }

    return max;
  }
}