// Move Zeros 移动零

@EASY
public class LC283 {

	@Array
  public void moveZeroes(int[] nums) {
    int index = 0;
    int n = nums.length;
    
    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) continue;
      int tmp = nums[i];
      nums[i] = nums[index];
      nums[index++] = tmp;
    }
    
    while (index != n) {
      nums[index++] = 0;
    }
  }
}
