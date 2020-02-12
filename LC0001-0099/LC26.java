// Remove Duplicates from Sorted Array 删除排序数组中的重复项

@EASY
public class LC26 {

  @TwoPointers
  public int removeDuplicates(int[] nums) {
    int fast = 0;
    int slow = 0;

    while (fast < nums.length) {
      if (nums[fast] == nums[slow]) {
        fast++;
        continue;
      }

      nums[++slow] = nums[fast++];
    }
      
    return slow + 1;
  }
}
