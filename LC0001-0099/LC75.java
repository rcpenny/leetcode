// Sort Colors

@MEDIUM
@Microsoft
public class LC75 {

  @TwoPointers
  public void sortColors(int[] nums) {
    if (nums == null || nums.length <= 1) return;

    int n = nums.length;

    int start = 0;
    int mid = 0;
    int end = n - 1;

    while (mid <= end) {
      if (nums[mid] == 1) {
        mid++;
      } else if (nums[mid] == 2) {
        swap(nums, mid, end);
        end--;
      } else if (nums[mid] == 0) {
        swap(nums, start, mid);
        mid++;
        start++;
      }
    }
  }

  private void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }
}