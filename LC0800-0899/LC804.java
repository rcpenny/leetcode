// Unique Morse Code Words 唯一摩尔斯密码词

@EASY
class LC804 {
  private final String[] codes = 
      {".-","-...","-.-.","-..",".","..-.","--.","....","..",
      ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
      "...","-","..-","...-",".--","-..-","-.--","--.."};

  @HashSet
  public int uniqueMorseRepresentations(String[] words) {
    Set<String> translation = new HashSet<>();

    for (String word : words) {
      translation.add(morseCode(word));
    }

    return translation.size();
  }

  private String morseCode(String word) {
    StringBuilder sb = new StringBuilder();
    for (char c : word.toCharArray()) {
      sb.append(codes[c - 'a']);
    }
    return sb.toString();
  }
}