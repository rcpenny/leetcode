// Find All Duplicates in an Array 数组中重复的数据

@MEDIUM
public class LC442 {
	
	@Array
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> twice = new ArrayList<>();

    // number 4' status is tracked at index 3

    // pos -> neg means appearing once
    // neg -> pos means appearing twice
    
    for (int i = 0; i < nums.length; i++) {
      int realNumber = Math.abs(nums[i]);
      int index = realNumber - 1;

      nums[index] = -nums[index];
      if (nums[index] > 0) twice.add(realNumber);
    }

    return twice;
  }
}
