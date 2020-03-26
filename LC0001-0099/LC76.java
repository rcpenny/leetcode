// Minimum Window Substring 最小覆盖子串

@HARD
@HighFreq
public class LC76 {
  int[] letters = new int[256];

  @TwoPointers
  public String minWindow(String source , String target) {
		for (int i = 0; i < target.length(); i++) {
      letters[target.charAt(i)]++;
    }

		int slow = 0;
		int fast = 0;
		int min_length = Integer.MAX_VALUE;
		
		String min_window = "";
			
    for (slow = 0; slow < source.length(); slow++) {
			
      while (fast < source.length() && !isAllFound()) {
        letters[source.charAt(fast)]--;
        fast++;
      }
			
      if (fast - slow < min_length && isAllFound()) {
        min_length = fast - slow;
        min_window = source.substring(slow, fast);
      }

			letters[source.charAt(slow)]++;
    }

    return min_window;     
  }
  
  private boolean isAllFound() {
    for (int i = 0; i < letters.length; i++) {
			if (letters[i] > 0) return false;
		}
    return true;
  }
}
