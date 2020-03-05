// Jump Game II 跳跃游戏 II

@HARD
public class LC45 {
  
	@Greedy
	public int jump(int[] nums) {
		int furthest = nums[0];
    int end = 0;
    int steps = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      furthest = Math.max(furthest, nums[i] + i);
      if (i == end) {
        end = furthest;
        steps++;
      }
    }

		return steps;
  }
}
