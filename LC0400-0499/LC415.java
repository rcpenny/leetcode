// 字符串相加 Add Strings

@EASY
public class LC415 {

	@String
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();

    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;

    while(i >= 0 || j >= 0 || carry != 0){
      carry += i >= 0 ? num1.charAt(i--) - '0' : 0;
      carry += j >= 0 ? num2.charAt(j--) - '0' : 0;
      
      sb.append(carry % 10);
      carry /= 10;
    }

    return sb.reverse().toString();
  }
}
