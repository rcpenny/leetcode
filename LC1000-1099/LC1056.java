// Confusing Number 易混淆数

@EASY
public class LC1056 {

	@Math
	public boolean confusingNumber(int N) {
		
		int n = N;
		int R = 0;

		while (n != 0) {
			int d = n % 10;
			
			if (d == 1 || d == 0 || d == 8) {
				R = R * 10 + d;
			} else if (d == 6) {
				R = R * 10 + 9;
			} else if (d == 9) {
				R = R * 10 + 6;
			} else {
				return false;
			}

			n /= 10;
		}

		return N != R;
	}
}
