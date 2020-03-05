// Verifying an Alien Dictionary 验证外星语词典

@EASY
class LC953 {
  private Map<Character, Integer> map;

	@HashTable
  public boolean isAlienSorted(String[] words, String order) {
    map = new HashMap<>();
    for (int i = 0; i < order.length(); i++)
      map.put(order.charAt(i), i + 1);

    for (int i = 0; i < words.length - 1; i++) {
      String prev = words[i];
      String next = words[i + 1];
      if (!compareWord(prev, next)) return false;
    }

    return true;
  }

  private boolean compareWord(String a, String b) {
    int ptr = 0;
    while (ptr < a.length() && ptr < b.length()) {
      char c1 = a.charAt(ptr);
      char c2= b.charAt(ptr);

      if (map.get(c1) < map.get(c2)) return true;
      if (map.get(c1) > map.get(c2)) return false;
      ptr++;
    }

    if (a.length() == ptr && b.length() > ptr) return true;

    return false;
  }
}
