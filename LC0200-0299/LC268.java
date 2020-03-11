// Missing Number 缺失数字

@EASY
public class LC268 {

	@Math
  public int missingNumber(int[] nums) {
    int n = nums.length;
    long sum = n * (n + 1) / 2;

    for (int num : nums) sum -= num;

    return (int) sum;
  }
}
