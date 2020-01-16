// Repeated String Match 重复叠加字符串匹配

@EASY
public class LC686 {

  @String
  public int repeatedStringMatch(String A, String B) {
    String s = "";

    int count = 0;
    int limit = B.length() / A.length() + 2;
    
    while (limit-- > 0) {
      s += A;
      count++;
      if (s.indexOf(B) >= 0) return count;
    }

    return -1;
  }
}