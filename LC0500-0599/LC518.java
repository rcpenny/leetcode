// Coin Change 2 零钱兑换 II

@MEDIUM
public LC518 {
  
  @DynamicProgramming
  public int change(int amount, int[] coins) {
    int[] f = new int[amount + 1];
    
    f[0] = 1;
    
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        f[i] += f[i - coin];
      }
    }
    
    return f[amount];
  }
}