// Intersection of Two Arrays II 两个数组的交集 II

@EASY
public class LC350 {

	@HashMap
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i = 0; i < nums1.length; ++i)
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);

		List<Integer> results = new ArrayList<Integer>();

		for (int i = 0; i < nums2.length; ++i) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				results.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1); 
			}
		}

		int result[] = new int[results.size()];
		
		for(int i = 0; i < results.size(); i++)
			result[i] = results.get(i);

		return result;
	}
}
