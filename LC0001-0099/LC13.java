// Roman to Integer 罗马数字转整数

@EASY
class LC13 {

  @Math
  public int romanToInt(String s) {
    Map<String, Integer> map = new HashMap<>();

    map.put("I", 1);
    map.put("IV", 4);
    map.put("V", 5);
    map.put("IX", 9);
    map.put("X", 10);
    map.put("XL", 40);
    map.put("L", 50);
    map.put("XC", 90);
    map.put("C", 100);
    map.put("CD", 400);
    map.put("D", 500);
    map.put("CM", 900);
    map.put("M", 1000);

    int result = 0;
    int i = 0;
    int n = s.length();

    while (i < n) {
      if (i + 1 < n && map.containsKey(s.substring(i, i + 2))) {
        result += map.get(s.substring(i, i + 2));
        i += 2;
      } else {
        result += map.get(s.substring(i, i + 1));
        i++;
      }
    }

    return result;
  }
}
