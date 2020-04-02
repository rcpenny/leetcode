// Integer to English Words 整数转换英文表示

@HARD
@HighFreq
public class LC273 {

  String[] IN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten",
      "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
  String[] IN_HUNDRED = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
      
  String[] OVER_THOUSAND = {"", "Thousand", "Million", "Billion"};
	
  @Array
  public String numberToWords(int num) {
    if (num == 0) return "Zero";

    String result = "";
    int i = 0;

    while (num > 0) {
      String sub = helper(num % 1000);

      if (sub != "") {
        result = sub + " " + OVER_THOUSAND[i] + " "+ result;
      }

      num /= 1000;
      i++;
    }

    return result.trim();
  }


  private String helper(int n) {
    String s;

    if (n < 20)
      s = IN_TWENTY[n];
    else if (n < 100) 
      s = IN_HUNDRED[n / 10] +  " " + IN_TWENTY[n % 10];
    else
      s = IN_TWENTY[n / 100] + " Hundred " + helper(n % 100);

    return s.trim();
  }
}
