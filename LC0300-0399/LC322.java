// Coin Change

@MEDIUM
@Google
public class LC322 {
  
  @DynamicProgramming
  public int coinChange(int[] coins, int amount) {
    Arrays.sort(coins);

    int[] f = new int[amount + 1];
    f[0] = 0;

    int i, j;

    for (i = 1; i <= amount; i++) {
      f[i] = Integer.MAX_VALUE;
      for (j = 0; j < coins.length; j++) {
        int comp = i - coins[j];
        if (comp >= 0 && f[comp] != Integer.MAX_VALUE) {
          f[i] = Math.min(f[i], f[comp] + 1);
        }
      }
    }

    return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
  }
}
