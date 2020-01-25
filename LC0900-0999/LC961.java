// N-Repeated Element in Size 2N Array 重复 N 次的元素

@EASY
public class LC961 {
  
  @HashTable
  public int repeatedNTimes(int[] A) {
    for (int k = 1; i <= 3; k++) {
      for (int i = 0; i < A.length - k; i++) {
        if (A[i] == A[i + k]) return A[i];
      }
    }
    return -1;
  }
}
