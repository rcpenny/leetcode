// Maximum Number of Balloons “气球” 的最大数量

@EASY
public class LC1189 {
  
  public int maxNumberOfBalloons(String text) {
    int b = 0, a = 0, l = 0, o = 0, n = 0;
    int count = 0;

    for (char c : text.toCharArray()) {
      if (c == 'b') b++;
      else if (c == 'a') a++;
      else if (c == 'l') l++;
      else if (c == 'o') o++;
      else if (c == 'n') n++;
    }

    while (b != 0 && a != 0 && l >= 2 && o >= 2 && n != 0) {
      b--;
      a--;
      l -= 2;
      o -= 2;
      n--;
      count++;
    }

    return count;
  }
}
