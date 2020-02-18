// Palindrome Number 回文数

@EASY
public class LC9 {

  @Array
  public boolean isPalindrome(int x) {
    if (x < 0) return false;

    List<Integer> digits = new ArrayList<>();

    while (x != 0) {
      digits.add(x % 10);
      x /= 10;
    }

    int left = 0;
    int right = digits.size() - 1;

    while (left < right) {
      if (digits.get(left) != digits.get(right)) return false;
      left++;
      right--;
    }

    return true;
  }
}