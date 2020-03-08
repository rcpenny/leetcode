// Range Sum Query - Immutable 区域和检索 - 数组不可变

@EASY
public class LC303 {}

@Prefixsum
class NumArray {
  int[] prefix;

  public NumArray(int[] nums) {
    prefix = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++)
      prefix[i + 1] = prefix[i] + nums[i];
  }
  
  public int sumRange(int i, int j) {
    return prefix[j + 1] - prefix[i];
  }
}

