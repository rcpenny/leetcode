// Array Partition I 数组拆分 I

@EASY
public class LC561 {

  @SortArray
  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);

    int result = 0;
    for (int i = 0; i < nums.length; i += 2) {
      result += nums[i];
    }

    return result;
  }
}