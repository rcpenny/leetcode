// Best Time to Buy and Sell Stock II 买卖股票的最佳时机 II

@EASY
public class LC122 {
  
  Greedy
  public int maxProfit(int[] prices) {
    int profit = 0;

    for (int i = 1; i < prices.length; i++)
      if (prices[i] > prices[i - 1])
        profit += prices[i] - prices[i - 1];

    return profit;
  }
}