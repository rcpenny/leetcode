// Longest Substring Without Repeating Characters

@MEDIUM
public class LC3 {

	@TwoPointers
	public int lengthOfLongestSubstring(String s) {
		int longest = 0;
		int n = s.length();

		int slow = 0;
		int fast = 0;

		int[] letterCount = new int[128];

		while (slow < n && fast < n) {
			char head = s.charAt(fast);
			char tail = s.charAt(slow);

			if (letterCount[head] == 0) {
				letterCount[head]++;
				longest = Math.max(longest, fast - slow + 1);
				fast++;
			} else {
				letterCount[tail]--;
				slow++;
			}
		}

		return longest;
	}
}
