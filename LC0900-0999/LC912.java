// Sort an Array 排序数组

@MEDIUM
public class LC912 {
	Random rand;

	@QuickSort
  public int[] sortArray(int[] nums) {
    rand = new Random();
    
    quicksort(nums, 0, nums.length - 1);

    return nums;
  }

  private void quicksort(int[] nums, int start, int end) {
    if (start >= end) return;
    
    int index = rand.nextInt(end - start + 1)  + start;
    int pivot = nums[index];

    int left = start;
    int right = end;

    while (left <= right && nums[left] < pivot) {
      left++;
    }

    while (left <= right && pivot < nums[right]) {
      right--;
    }

    if (left <= right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
      right--;
      left++;
    }

    quicksort(nums, start, right);
    quicksort(nums, left, end);
  }
}
