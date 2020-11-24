// 1512 好数对的数目 Number of Good Pairs

// 1 <= nums.length <= 100
//  1 <= nums[i] <= 100

@EASY
@HashMap
public class LC1512 {
  public int numIdenticalPairs(int[] nums) {
    int[] count = new int[101];
    int result = 0;

    for(int i = 0; i < nums.length; i++) {
      int value = nums[i];
      result += count[value];
      count[value]++;
    }

    return result;
  }
}