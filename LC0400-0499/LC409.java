// Longest Palindrome 最长回文串

@EASY
public class LC409 {
	public int longestPalindrome(String s) {
		if (s == null || s.length() == 0) return 0;
		
		int result = 0;
		int singleFlag = 0;
		int[] charFreq = new int[256];
		
		for (char c : s.toCharArray()) {
			if (charFreq[c] == 0) {
				charFreq[c] = 1;
				singleFlag++;
			} else {
				charFreq[c] = 0;
				result += 2;
				singleFlag--;
			}
		}

		return result += singleFlag > 0 ? 1 : 0;
	}
}
