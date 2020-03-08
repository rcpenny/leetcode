// Length of Last Word 最后一个单词的长度

@EASY
public class LC58 {
	
	@String
  public int lengthOfLastWord(String s) {
    int len = s.length();
		int count = 0;

    for (int i = len - 1; i >= 0; i--) {
      if(s.charAt(i) != ' ') ++count;
      else if (count != 0) return count;
    }

    return count;
  }
}
