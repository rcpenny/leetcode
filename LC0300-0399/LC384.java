// Shuffle an Array 打乱数组

@MEDIUM
public class LC384 {
  private int[] nums;
  
	@Array
  public ShuffleArray(int[] nums) {
      this.nums = nums;
  }
  
  public int[] reset() {
    return nums;
  }

  public int[] shuffle() {
    int[] rand = new int[nums.length];
    
		for (int i = 0; i < nums.length; i++){
      int r = (int) (Math.random() * (i+1));

      rand[i] = rand[r];
      rand[r] = nums[i];
    }

    return rand;
  }
}
