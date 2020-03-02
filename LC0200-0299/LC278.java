//  First Bad Version 第一个错误的版本

@EASY
public class LC278{}

@BinarySearch
public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    if (n <= 1) return n;
    
    int start = 1, end = n;
    
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      
      if (isBadVersion(mid) == false) start = mid;
      else end = mid;
    }
      
    if (isBadVersion(start) == true) return start;
    return end;
  }
}
