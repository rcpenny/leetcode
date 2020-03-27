// 3Sum 三数之和

@MEDIUM
@HighFreq
class LC15 {

  @TwoPointers
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new  ArrayList<>();

    if (nums == null || nums.length < 3) return result;

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      twoSum(nums, i, result);
    }

    return result;
  }

  private void twoSum(int[] nums, int i, List<List<Integer>> result) {
    int target = 0 - nums[i];
    int left = i + 1;
    int right = nums.length - 1;

    while (left < right) {
      int tmp = nums[left] + nums[right];
      if (target == tmp) {
        List<Integer> triple = Arrays.asList(nums[i], nums[left], nums[right]);
        result.add(triple);
        left++;
        right--;
        while (left < right && nums[left] == nums[left - 1]) left++;
        while (left < right && nums[right] == nums[right + 1]) right--;
      } else if (tmp < target) {
        left++;
      } else if (tmp > target) {
        right--;
      }
    }
  }
}
