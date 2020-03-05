// Minimum Domino Rotations For Equal Row 行相等的最少多米诺旋转

@MEDIUM
public class lc1007 {

	@Greedy
  public int minDominoRotations(int[] A, int[] B) {
    int result = Integer.MAX_VALUE;
    
    Set<Integer> set_a = new HashSet<>();
    for (int elem : A) set_a.add(elem);
    
    // check A first
    for (int elem : set_a) {
      int swaps = 0;
      for (int i = 0; i < A.length; i++) {
        if (A[i] == elem) {
          if (i == A.length - 1) result = Math.min(result, swaps);
          continue;
        }
        if (B[i] == elem) {
          swaps++;
          if (i == A.length - 1) result = Math.min(result, swaps);
          continue;
        }
        break;
      }
    }

    Set<Integer> set_b = new HashSet<>();
    for (int elem : B) set_b.add(elem);
    
    // check B
    for (int elem : set_b) {
      int swaps = 0;
      for (int i = 0; i < B.length; i++) {
        if (B[i] == elem) {
          if (i == A.length - 1) result = Math.min(result, swaps);
          continue;
        }
        if (A[i] == elem) {
          swaps++;
          if (i == B.length - 1) result = Math.min(result, swaps);
          continue;
        }
        break;
      }
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
