// Trapping Rain Water 接雨水

@HARD
public class LC42 {

  @TwoPointers
  public int trap(int[] height) {
    int rain = 0;

    int left = 0;
    int right = height.length - 1;

    int leftMax = 0;
    int rightMax = 0;

    while (left < right) {

      if (height[left] < height[right]) {
        if (height[left] < leftMax) rain += leftMax - height[left];
        else leftMax = height[left];
        left++;
        continue;
      }

      if (height[right] < rightMax) rain += rightMax - height[right];
      else rightMax = height[right];
      right--;
    }

    return rain;
  }
}
