// Assign Cookies 分发饼干

@EASY
public class LC455 {

	@Greedy
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);

    int j = 0;
    
    for (int i : s) {
      if (i >= g[j]) {
        j++;
        if (j >= g.length) break;
      }
    }

    return j;
  }

}
