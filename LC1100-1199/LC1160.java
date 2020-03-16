// Find Words That Can Be Formed by Characters 拼写单词

@EASY
public class LC1160 {

	@HashTable
  public int countCharacters(String[] words, String chars) {
    int[] tmp = new int[26];

    for (char c : chars.toCharArray()) {
      tmp[c - 'a']++;
    }

    int count = 0;

    for (String word : words) {
      int[] letters = Arrays.copyOf(tmp, 26);
      boolean found = true;

      for (char c : word.toCharArray()) {
        if (letters[c -'a'] == 0) {
          found = false;
          break;
        }
        letters[c - 'a']--;
      }
      count += found ? word.length() : 0;
    }

    return count;
  }
}
