// Find in Mountain Array 山脉数组中查找目标值

@HARD
public class LC1095 {

  @BinarySearch
  public int findInMountainArray(int target, MountainArray mountainArr) {
    int len = mountainArr.length();
    int left = 0;
    int right = len - 1;
      
    int maxIndex = findMaxIndex(left, right, target, mountainArr);
      
    int leftIndex = findLeftArr(left, maxIndex, target, mountainArr);
      
    if (leftIndex != -1) {
      return leftIndex;
    }
      
    int rightIndex = findRightArr(maxIndex, right, target, mountainArr);
      
    return rightIndex;
  }
  
  private int findMaxIndex(int left, int right, int target,  MountainArray mountainArr) {
    while (left < right) {
      int mid = (left + right) / 2;
      if (mountainArr.get(mid) > mountainArr.get(mid+1)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
  
  private int findLeftArr(int left, int maxIndex, int target, MountainArray mountainArr) {
    while (left < maxIndex) {
      int mid = (left + maxIndex) >>> 1;
      if (mountainArr.get(mid) < target) {
          left = mid + 1;
      } else {
          maxIndex = mid;
      }
    }
    if (mountainArr.get(left) != target) {
        return -1;
    }
    return left;
  }
  
  private int findRightArr(int maxIndex, int right, int target, MountainArray mountainArr) {
    while (maxIndex < right) {
      int mid = (maxIndex + right) >>> 1;
      if (mountainArr.get(mid) > target) {
        maxIndex = mid + 1;
      } else {
        right = mid;
      }
    }
    if (mountainArr.get(right) != target) {
      return -1;
    }
    return right;
  }
}
