// Plus One 加一

@EASY
public class LC66 {

  @Array
  public int[] plusOne(int[] digits) {
    boolean flag = true;

    int n = digits.length;
    int[] result = new int[n];
    int carry = 1;

    for (int i = n - 1; i >= 0; i--) {
      result[i] = (digits[i] + carry) % 10;
      carry = (digits[i] + carry) / 10;
      
      if (digits[i] != 9) flag = false;
    }

    if (flag) {
      int[] spec = new int[n + 1];
      spec[0] = 1;
      return spec;
    }

    return result;
  }
}