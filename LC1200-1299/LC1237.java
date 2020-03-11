// Find Positive Integer Solution for a Given Equation 找出给定方程的正整数解

@EASY
public class LC1237 {
  public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
    int x;
    int y;

		List<List<Integer>> result = new ArrayList<>();

    x = 1;
    y = 1000;

    while (x <= y) {
      int tmp = customfunction.f(x, y);
      if (tmp < z) x++;
      else if (tmp > z) y--;
      else result.add(Arrays.asList(x++, y));
    }

    x = 1000;
    y = 1;

    while (x > y) {
      int tmp = customfunction.f(x, y);
      if (tmp < z) y++;
      else if (tmp > z) x--;
      else result.add(Arrays.asList(x, y++));
    }

    return result;
  }
}
