// Implement strStr() 实现 strStr()

@EASY
public class LC28 {

	@TwoPointers
  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null || needle.length() > haystack.length()) {
      return -1;
    }

    if (needle.length() == 0) return 0;

    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      for (int j = 0; j < needle.length(); j++) {
        if (needle.charAt(j) != haystack.charAt(j + i)) {
          break;
        }
        if (j == needle.length() - 1) {
          return i;
        }
      }
    }

    return -1;
  }
}
