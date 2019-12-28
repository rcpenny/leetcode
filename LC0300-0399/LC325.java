// Maximum Size Subarray Sum Equals k

@MEDIUM
public class LC325 {
  
  @HashTable
  @SubArray
  public int maxSubArrayLen(int[] nums, int k) {
    if (nums == null || nums.length == 0) return 0;

    Map<Integer, Integer> map = new HashMap<>();

    int max = 0;
    int prefix = 0;
    map.put(prefix, -1);

    for (int i = 0; i < nums.length; i++) {
      prefix += nums[i];

      int comp = prefix - k;
      if (map.containsKey(comp)) {
        max = Math.max(max, i - map.get(comp));
      }

      if (!map.containsKey(prefix)) {
        map.put(prefix, i);
      }
    }

    return max;
  }
}