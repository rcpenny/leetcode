// Is Subsequence 判断子序列

@EASY
public class LC392 {

	@Greedy
  public boolean isSubsequence(String s, String t) {
    int count = 0;
    int index = 0;

    for (char c : s.toCharArray()) {
      while (index < t.length() && t.charAt(index) != c) {
        index++;
      }
      if (index != t.length()) {
        index++;
        count++;
      }
    }

    return count == s.length();
  }
}
