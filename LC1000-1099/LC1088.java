// Confusing Number II 易混淆数 II

@HARD
public class LC1088 {

	private final int[] digits = {0, 1, 6, 8, 9};
	private int count = 0;

	@Math
	@Backtracking
	public int confusingNumberII(int N) {
		backtrack(N, 0L);
		return count;
	}

	private void backtrack(int N, long number) {
    for (int i = 0; i < digits.length; i++) {
      long next = number * 10 + digits[i];
      
      if (next > 0 && next <= N) {
        if (isConfusingNumber(next)) count++;
        backtrack(N, next);
      }
    }
	} 
	
	public boolean isConfusingNumber(long N) {		
		long n = N;
		long R = 0;

		while (n != 0) {
			long d = n % 10;
			
			if (d == 1 || d == 0 || d == 8) {
				R = R * 10 + d;
			} else if (d == 6) {
				R = R * 10 + 9;
			} else if (d == 9) {
				R = R * 10 + 6;
			}

			n /= 10;
		}

		return N != R;
	}
}
