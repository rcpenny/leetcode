// Next Permutation 下一个排列

@MEDIUM
@HighFreq
public class LC31 {

  @Array
  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i + 1] <= nums[i]) i--;

    if (i >= 0) {
      int j = nums.length - 1;
      while (j >= 0 && nums[j] <= nums[i]) j--;
      swap(nums, i, j);
    }

    reverse(nums, i + 1);
  }

  private void reverse(int[] nums, int start) {
    int left = start;
    int right = nums.length - 1;
    
		while (left < right) swap(nums, left++, right--);
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
