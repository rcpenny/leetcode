// Subarray Sum Equals K 和为K的子数组

@MEDIUM
public class LC560 {

	@PrefixSum
	@HashTable
	public int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;

		int count = 0;
		int n = nums.length;
		
		Map<Integer, Integer> map = new HashMap<>();

		int[] prefix = new int[n + 1];
		prefix[0] = 0;
		map.put(0, 1);

		for (int i = 1; i <= n; i++) {
			prefix[i] = prefix[i - 1] + nums[i - 1];

			int comp = prefix[i] - k;
			
			if (map.containsKey(comp)) {
				count += map.get(comp);
			}
			map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
		}

		return count;
	}
}
