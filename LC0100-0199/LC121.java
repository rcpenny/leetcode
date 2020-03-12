// Best Time to Buy and Sell Stock 买卖股票的最佳时机

@EASY
class LC121 {

  @DP
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) return 0;

    int profit = 0;
    int lowest = prices[0];

    for (int i = 0; i < prices.length; i++) {
      profit = Math.max(profit, prices[i] - lowest);
      lowest = Math.min(lowest, prices[i]);
    }

    return profit;
  }
}
