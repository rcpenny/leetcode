// Valid Triangle Number 有效三角形的个数

@MEDIUM
public class LC611 {

	@TwoPointers
  public int triangleNumber(int[] A) {
    if (A == null || A.length < 3) return 0;

    Arrays.sort(A);
    
    int n = A.length;
    
    int count = 0;
    
    // i 从大到小
    for (int i = n - 1; i >= 2; i--) {
      int left = 0;
      int right = i - 1;
      
      while (left < right) {
				// 短边相加大于最长边
        if (A[left] + A[right] > A[i]) {
          count = count + (right - left);
          right--;
        } else {
          left++;
        }
      }
    }

    return count;
  }
}
