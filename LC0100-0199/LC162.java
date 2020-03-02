// Find Peak Element 寻找峰值

@MEDIUM
public class LC162 {

  @BinarySearch
  public int findPeakElement(int[] A) {
		if (A == null || A.length == 0) return -1;
		if (A.length == 1) return 0;
    
    int start = 0;
    int end = A.length - 1;

    while (start + 1 < end) {
      int middle = start + (end - start) / 2;
      if (A[middle] > A[middle - 1] && A[middle] < A[middle + 1]) // 上升线
        start = middle;
      else if (A[middle] < A[middle - 1] && A[middle] > A[middle + 1]) // 谷底
        end = middle;
      else if (A[middle] < A[middle - 1] && A[middle] < A[middle + 1]) // 下降线
        end = middle;
      else
        return middle;
    }
    
    return A[end] > A[start] ? end : start;
  }
}
