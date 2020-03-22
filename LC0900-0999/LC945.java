// Minimum Increment to Make Array Unique 使数组唯一的最小增量

@MEDIUM
public class LC945 {
	
	@Array
	public int minIncrementForUnique(int[] A) {
    if (A.length == 0) return 0;

    Arrays.sort(A);
    int moves = 0;

    for (int i = 1; i < A.length; i++) {
      if (A[i] > A[i - 1]) continue;

      moves += A[i - 1] + 1 - A[i];
      A[i] = A[i - 1] + 1;
    }

    return moves;
  }
}
