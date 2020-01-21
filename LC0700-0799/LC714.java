// Best Time to Buy and Sell Stock with Transaction Fee 买卖股票的最佳时机含手续费

@MEDIUM
public class LC714 {

  @DynamicProgramming
  public int maxProfit(int[] prices, int fee) {
    int cash = 0;
    int hold = -prices[0];

    for (int i = 1; i < prices.length; i++) {
      cash = Math.max(cash, hold + prices[i] - fee);
      hold = Math.max(hold, cash - prices[i]);
    }

    return cash;
  }
}