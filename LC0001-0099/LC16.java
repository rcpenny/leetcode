// 3Sum Closest 最接近的三数之和

@MEDIUM
public class LC16 {
	private int minDiff = Integer.MAX_VALUE;
	private int result = 0;

	@TwoPointers
  public int threeSumClosest(int[] numbers, int target) {
    Arrays.sort(numbers);

		for (int i = 0; i < numbers.length - 2; i++) {
			if (i > 0 && numbers[i] == numbers[i - 1]) continue;
			twoSumCloset(numbers, i, target);

      if (minDiff == 0) return result;
		}

		return result;
	}

	private void twoSumCloset(int[] numbers, int start, int target) {
		int first = numbers[start];
		int left = start + 1;
    int right = numbers.length - 1;

		while (left < right) {
			int sum = first + numbers[left] + numbers[right];
			if (sum == target) {
        minDiff = 0;
				result = sum;
				left++;
				right--;
			} 
      
      else if (sum > target) {
				if (sum - target < minDiff) {
					minDiff = sum - target;
					result = sum;
				}
				right--;
			} 
      
      else {
				if (target - sum < minDiff) {
					minDiff = target - sum;
					result = sum;
				}
				left++;
			}
		}
	}
}
