// LC290 单词规律 word pattern

@EASY
public class LC290 {
  public boolean wordPattern(String pattern, String s) {
    char[] charPattern = pattern.toCharArray();
    String[] words = s.split(" ");

    if (charPattern.length != words.length) {
      return false;
    }

    Map<Character, String> map = new HashMap<>();
    Set<String> usedWords = new HashSet<>();
    for (char c : charPattern) {
      map.put(c, null);
    }

    for (int i = 0; i < charPattern.length; i++) {
      char c = charPattern[i];
      if (map.get(c) == null) {
        if (usedWords.contains(words[i])) {
          return false;
        }
        map.put(c, words[i]);
        usedWords.add(words[i]);
      } else {
        String value = map.get(c);
        if (!value.equals(words[i])) {
          return false;
        }
      }
    }
    return true;
  }
}
