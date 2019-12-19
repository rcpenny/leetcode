// Merge Sorted Array

@EASY
public class LC88 {

  @TwoPointers
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index = m-- + n-- - 1;

    while (index >= 0) {
      if (m >= 0 && n >= 0) {
        nums1[index--] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
        continue;
      }

      nums1[index--] = m >= 0 ? nums1[m--] : nums2[n--];
    }
  }
}