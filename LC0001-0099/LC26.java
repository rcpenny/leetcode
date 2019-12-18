// Remove Duplicates from Sorted Array

@EASY
public class LC26 {

  @TwoPointers
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    
    int fast = 1;
    int slow = 1;

    while (fast < nums.length) {
      if (nums[fast] == nums[fast - 1]) {
        fast++;
        continue;
      }

      nums[slow++] = nums[fast++];
    }

    return slow;
  }
}