// Remove Element 移除元素

@EASY
public class LC27 {

	@Array
  public int removeElement(int[] nums, int val) {
    int slow = 0;
    int count = 0;

    for (int fast = 0; fast < nums.length; fast++) {
      if (nums[fast] == val) continue;
      nums[slow++] = nums[fast];
      count++;
    }

    return count;
  }
}
