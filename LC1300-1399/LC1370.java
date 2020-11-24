// 上升下降字符串 Increasing Decreasing String

// 1 <= s.length <= 500
//  s 只包含小写英文字母。

@EASY
@String
public class LC1370 {
  public String sortString(String s) {
    if (s == null || s.length() <= 1) {
      return s;
    }

    StringBuilder result = new StringBuilder();
    
    int[] charCounts = new int[26];
    for (char c : s.toCharArray()) {
      charCounts[c - 'a']++;
    }

    int len = s.length();
    boolean forward  = true;
    while (len > 0) {
      int index = forward ? 0 : 25;
      int move = forward ? 1 : -1;

      for (int i = 0; i < 26; i++) {
        if (charCounts[index] > 0) {
          result.append((char) ('a' + index));
          charCounts[index]--;
          len--;
        }
        index += move;
      }

      forward = !forward;
    }

    return result.toString();
  }
}