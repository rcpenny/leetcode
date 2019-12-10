// Two Sum

@EASY
class LC1 {

  @HashTable
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> numToIndex = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int comp = target - nums[i]; // complement number

      if (numToIndex.containsKey(comp)) {
        result[0] = numToIndex.get(comp);
        result[1] = i;
        break;
      }
      
      numToIndex.put(nums[i], i);
    }

    return result;
  }
}
