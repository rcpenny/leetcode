// Reverse Words in a String II

@MEDIUM
@Microsoft
public class LC186 {

  @String
  public void reverseWords(char[] s) {
    int n = s.length;
    int fast = 0;
    int slow = 0;

    while (fast < n) {
      if (s[fast] != ' ') {
        fast++;
        continue;
      }

      reverse(s, slow, fast - 1);
      fast++;
      slow = fast;
    }
    reverse(s, slow, fast - 1);
    reverse(s, 0, n - 1);
  }

  private void reverse(char[] s, int start, int end) {
    while (start < end) {
      char tmp = s[start];
      s[start] = s[end];
      s[end] = tmp;
      start++;
      end--;
    }
  }
}
