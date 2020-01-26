// Coin Change 零钱兑换

@MEDIUM
public class LC322 {

  @DynamicProgramming
  public int coinChange(int[] coins, int amount) {
    int[] f = new int[amount + 1];

    for (int i = 1; i <= amount; i++) {
      f[i] = Integer.MAX_VALUE;
      for (int coin : coins) {
        int comp = i - coin;
        if (comp >= 0 && f[comp] != Integer.MAX_VALUE) {
          f[i] = Math.min(f[i], f[comp] + 1);
        }
      }
    }

    return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
  }
}
