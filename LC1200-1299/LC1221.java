// Split a String in Balanced Strings 分割平衡字符串

@EASY
public class LC1221 {

	@Greedy
  public int balancedStringSplit(String s) {
    int count = 0;
    int flag = 0;

    for (char c : s.toCharArray()) {
      flag += c == 'L' ? 1 : -1;
      count += flag == 0 ? 1 : 0;
    }

    return count;
  }
}
