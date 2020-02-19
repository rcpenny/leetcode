// House Robber 打家劫舍

@EASY
public class LC198 {
  
  @DynamicProgramming
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int n = nums.length;

    int[] f = new int[n + 1];
    f[0] = 0;
    f[1] = nums[0];

    for (int i = 2; i <= n; i++) {
      f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
    }

    return f[n];
  }

  // O(n) -> O(1)
  public int robO1(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int n = nums.length;

    int first = 0;
    int second = nums[0];
    int third = nums[0];

    for (int i = 1; i < n; i++) {
      third = Math.max(second, first + nums[i]);
      first = second;
      second = third;
    }

    return third;
  }
}