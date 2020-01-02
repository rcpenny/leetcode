// Peak Index in a Mountain Array

@EASY
public LC852 {

  @BinarySearch
  public int peakIndexInMountainArray(int[] A) {    
    int start = 0;
    int end = A.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      
      if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) // 上升线
        start = mid;
      else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) // 谷底
        end = mid;
      else if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) // 下降线
        end = mid;
      else
        return mid;
    }

    return A[end] > A[start] ? end : start;      
  }
}