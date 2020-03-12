// Reverse Vowels of a String 反转字符串中的元音字母

@EASY
public class LC345 {

	@TwoPointers
  public String reverseVowels(String s) {
    Set<Character> vowels = 
      Set.of('a', 'e', 'i', 'o', 'u', 
             'A', 'E', 'I', 'O', 'U');

    int start = 0;
    int end = s.length() - 1;

    char[] crray = s.toCharArray();

    while (start < end) {
      while (start < end && !vowels.contains(crray[start])) {
        start++;
      }

      while (start < end && !vowels.contains(crray[end])) {
        end--;
      }

      char tmp = crray[start];
      crray[start] = crray[end];
      crray[end] = tmp;

      start++;
      end--;
    }

    return new String(crray);
  }
}
