// Count and Say 外观数列

@EASY
public class LC38 {

	@String
  public String countAndSay(int n) {
    if (n <= 0) return "";

    String[] seq = new String[n];
    seq[0] = "1";

    for (int i = 1; i < n; i++) {
      seq[i] = convert(seq[i - 1]);
    }
    
    return seq[n - 1];
  }

  public String convert(String str) {
    StringBuilder result = new StringBuilder();

    int count = 1;
    for (int i = 0; i < str.length(); i++) {
      if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
          count++;
      } else {
        result.append(count).append(str.charAt(i));
        count = 1;
      }
    }

    return new String(result);
  }
}
