// Longest Substring with At Most Two Distinct Characters 至多包含两个不同字符的最长子串

@MEDIUM
public class LC159 {
  
  @HashTable
  @SlidingWindow
  @TwoPointers
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s == null || s.length() == 0) return 0;

    int n = s.length();
    int longest = 1;

    int fast = 0;
    int slow = 0;

    Map<Character, Integer> freq = new HashMap<>();

    while (fast < n) {
      char head = s.charAt(fast);

      freq.put(head, freq.getOrDefault(head, 0) + 1);
      fast++;

      while (freq.size() == 3) {
        char tail = s.charAt(slow);
        int count = freq.get(tail);
        
        if (count == 1) freq.remove(tail);
        else freq.put(tail, count - 1);
        slow++;
      }

      longest = Math.max(longest, fast - slow);
    }

    return longest;
  }
}