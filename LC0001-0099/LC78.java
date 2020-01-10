// Subsets

@MEDIUM
public class LC78 {

  @Backtracking
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    helper(nums, 0, new ArrayList<>(), result);

    return result;
  }

  private void helper(int[] nums, int index, List<Integer> sub, List<List<Integer>> result) {
    result.add(new ArrayList<>(sub));

    for (int i = index; i < nums.length; i++) {
      sub.add(nums[i]);
      helper(nums, i + 1, sub, result);
      sub.remove(sub.size() - 1);
    }
  }
}