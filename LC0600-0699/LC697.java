// Degree of an Array 数组的度

@EASY
public class LC697 {
	
	@Array
	public int findShortestSubArray(int[] nums) {
		if (nums.length == 1) return 1;

		int max = 0;
		Map<Integer, Integer> numToFreq = new HashMap<>();

		for (int num : nums) {
			if (!numToFreq.containsKey(num)) numToFreq.put(num, 1);
			else numToFreq.put(num, numToFreq.get(num) + 1);
			max = Math.max(max, numToFreq.get(num));
		}
        
    if (max == 1) return 1;

		Map<Integer, List<Integer>> numToIndex = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int tmp = nums[i];
			if (numToFreq.get(nums[i]) != max) continue;

			if (!numToIndex.containsKey(nums[i])) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				list.add(i);
				numToIndex.put(tmp, list);
			} else {
				numToIndex.get(tmp).set(1, i);
			}
		}

    int result = nums.length;
    for (int num : numToIndex.keySet()) {
      int left = numToIndex.get(num).get(0);
      int right = numToIndex.get(num).get(1);
      result = Math.min(result, right - left + 1);
    }
    
		return result;
	}
}
