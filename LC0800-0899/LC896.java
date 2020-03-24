// Monotonic Array 单调数列

@EASY
public class L896 {
	
	@Array
	public boolean isMonotonic(int[] A) {
    int n = A.length;
    boolean increasing = A[0] < A[n - 1] ? true : false;

    if (A[0] == A[n - 1]) {
      for (int i = 1; i < n; i++)
        if (A[i] != A[i - 1]) return false;
    }

    if (increasing) {
      for (int i = 1; i < n; i++)
        if (A[i] < A[i - 1]) return false;
    }

    if (!increasing) {
      for (int i = 1; i < n; i++)
        if (A[i] > A[i - 1]) return false;
    }

    return true;
  }
}
