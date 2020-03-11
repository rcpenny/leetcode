// Maximize Sum Of Array After K Negations K 次取反后最大化的数组和

@EASY
public class LC1005 {

	@Greedy
  public int largestSumAfterKNegations(int[] A, int k) {
    Arrays.sort(A);
    
    int minIndex = 0;

    while (k > 0) {
      A[minIndex] = -A[minIndex];
      k--;
      
      if (minIndex + 1 < A.length && A[minIndex] > A[minIndex + 1]) {
        minIndex++;
      }
    }

    return Arrays.stream(A).sum();
  }
}
