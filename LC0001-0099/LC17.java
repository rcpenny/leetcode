// Letter Combinations of a Phone Number

@MEDIUM
public class LC17 {

  private static final String[] letters = 
      {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  @DFS
  @Backtracking
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) return result;

    search(digits.toCharArray(), 0, new StringBuilder(), result);

    return result;
  }

  private void search(char[] digits, int index, StringBuilder sb, List<String> result) {
    if (index == digits.length) {
      result.add(sb.toString());
      return;
    }

    int digit = digits[index] - '0';

    for (char c : letters[digit].toCharArray()) {
      sb.append(c);
      search(digits, index + 1, sb, result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}