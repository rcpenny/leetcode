// Arranging Coins 排列硬币

@EASY
public class LC441 {

	@BinarySearch
	public int arrangeCoins(int n) {
    int start = 0;
    int end = n;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      long required = coinsRequired(mid);

      if (required > n) end = mid;
      else start = mid;
    }

    System.out.println(end);
    if (n >= coinsRequired(end)) return end;
    return start;
  }

  private long coinsRequired(int k) {
    return (long) (1 + k) * k / 2;
  }
}

// O(N) -> O(logN) -> 二分 -> 二分答案
