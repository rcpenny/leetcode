// Valid Palindrome 验证回文串

@EASY
class LC125 {

  @TwoPointers
  public boolean isPalindrome(String s) {
    if (s.length() == 0) return true;

    int left = 0;
    int right = s.length() - 1;
    
    char[] c = s.toCharArray();

    while (left < right) {
      
      while (left < right && !validCharacter(c[left])) {
        left++;
      }

      while (left < right && !validCharacter(c[right])) {
        right--;
      }

      if (Character.toLowerCase(c[left]) != Character.toLowerCase(c[right])) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }

  private boolean validCharacter(char c) {
    return Character.isLetter(c) || Character.isDigit(c);
  }
}
