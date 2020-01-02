// Container With Most Water

@MEDIUM
public class LC11 {

  @TwoPointers
  public int maxArea(int[] height) {
    int max = 0;

    int left = 0;
    int right = height.length - 1;

    while (left < right) {
      int min = Math.min(height[left], height[right]);
      max = Math.max(max, min * (right - left));

      if (height[left] < height[right]) left++;
      else right--;
    }

    return max;
  }
}