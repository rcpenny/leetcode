// Valid Anagram

@EASY
class LC242 {

  @HashTable
  public boolean isAnagram(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();

    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (char c : t.toCharArray()) {
      if (!map.containsKey(c)) return false;

      int freq = map.get(c);
      
      if (freq == 1) map.remove(c);
      else map.put(c, freq - 1);
    }

    return map.size() == 0;
  }
}
