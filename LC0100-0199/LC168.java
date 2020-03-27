// Excel Sheet Column Title Excel表列名称

@EASY
public class LC168 {

	@Math
	public String convertToTitle(int n) {
    StringBuilder str = new StringBuilder();

    while (n > 0) {
      n--;
      str.append((char) ((n % 26) + 'A'));
      n /= 26;
    }

    return str.reverse().toString();    
  }
}
