// Contains Duplicate 存在重复元素

@EASY
public class LC217 {

	@Array
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		
		for (int num : nums) {
			if (!set.contains(num)) set.add(num);
			else return true;
		}
		
		return false;
	}
}
