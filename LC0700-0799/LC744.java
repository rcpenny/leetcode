// Find Smallest Letter Greater Than Target 寻找比目标字母大的最小字母

@EASY
public class LC744 {

	@BinarySearch
  public char nextGreatestLetter(char[] letters, char target) {
    int n = letters.length;
    int start = 0;
    int end = n - 1;
    
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (letters[mid] <= target) start = mid;
      else end = mid;
    }

    if (letters[start] > target) return letters[start];
    
    return (end == n - 1) && (letters[end] <= target) ? letters[0] : letters[end];
  }
}
