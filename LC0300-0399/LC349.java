// Intersection of Two Arrays 两个数组的交集

@EASY
public class LC349 {

	@HashSet
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> intersection = new HashSet<>();
		Set<Integer> set1 = new HashSet<>();
				
		for (int num : nums1) set1.add(num);
		
		for (int num : nums2)
			if (set1.contains(num))
				intersection.add(num);

						
		int j = 0;
		int[] result = new int[intersection.size()];
		for (int val : intersection) result[j++] = val;

		return result;
	}
}
