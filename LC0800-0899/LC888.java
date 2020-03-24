// 公平的糖果交换 Fair Candy Swap

@EASY
public class LC888 {

	@Array
  public int[] fairCandySwap(int[] A, int[] B) {
    int diff = Arrays.stream(B).sum() - Arrays.stream(A).sum();
    diff /= 2;
    
    Set<Integer> set = new HashSet<>();
    for (int b : B) set.add(b);

    int[] result = new int[2];

    for (int a : A) {
      if (set.contains(a + diff)) {
        result[0] = a;
        result[1] = a + diff;
        break;
      }
    }

    return result;
  }
}
