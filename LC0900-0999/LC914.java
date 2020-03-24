// X of a Kind in a Deck of Cards 卡牌分组

@EASY
public class LC914 {
	
	@Array
	public boolean hasGroupsSizeX(int[] deck) {
    int[] count = new int[10000];
    for (int d : deck) count[d]++;

    int g = -1;
    for (int i = 0; i < 10000; i++) {
      if (count[i] == 0) continue;
      if (g == -1) g = count[i];
      else g = gcd(g, count[i]);
    }

    return g >= 2;
  }

  private int gcd(int x, int y) {
    return x == 0 ? y : gcd(y % x, x);
  }
}
