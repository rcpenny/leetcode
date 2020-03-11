// Check If a Number Is Majority Element in a Sorted Array 检查一个数是否在数组中占绝大多数

@EASY
public class LC1150 {

	@BinarySearch
  public boolean isMajorityElement(int[] A, int target) {    
    int firstPosition = 0;
    int lastPosition = 0;  
    
    int start = 0, end = A.length - 1;
    while (start + 1 < end) {
      int middle = start + (end - start) / 2;
      if (A[middle] >= target) end = middle;
      else start = middle;
    }
    firstPosition = (A[start] == target) ? start : end;

    int start_ = 0, end_ = A.length - 1;
    while (start_ + 1 < end_) {
      int middle = start_ + (end_ - start_) / 2;
      if (A[middle] <= target) start_ = middle;
      else end_ = middle;
    }
    lastPosition = (A[end_] == target) ? end_ : start_;

    if (A[firstPosition] != target) return false;
    
    return lastPosition - firstPosition + 1 > A.length / 2;
  }
}
