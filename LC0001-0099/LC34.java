// Find First and Last Position of Element in Sorted Array 在排序数组中查找元素的第一个和最后一个位置

@MEDIUM
public class LC34 {

  @BinarySearch
  public int[] searchRange(int[] A, int target) {
    int[] result = {-1, -1};

    if (A == null || A.length == 0) {
      return result;
    }
    
    int start = 0;
    int end = A.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (A[mid] >= target) end = mid;
      else start = mid;
    }

    if (A[start] == target) result[0] = start;
    else if (A[end] == target) result[0] = end;
    else return result;

    start = 0;
    end = A.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (A[mid] <= target) start = mid;
      else end = mid;
    }
    
    if (A[end] == target) result[1] = end;
    else if (A[start] == target) result[1] = start;
    
    return result;
  }
}
