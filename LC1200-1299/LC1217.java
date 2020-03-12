// Play with Chips 玩筹码

@EASY
public class LC1217 {
  public int minCostToMoveChips(int[] chips) {
    int odd = 0;
    int even = 0;

    for (int c : chips) {
      if (c % 2 == 0) even++;
      else odd++;
    }

    return odd <= even ? odd : even;
  }
}
