// Reverse Words in a String

@MEDIUM
@Microsoft
public class LC151 {

  @String
  public String reverseWords(String s) {
    if (s == null) return s;

    String[] words = s.trim().split(" ");

    StringBuilder sb = new StringBuilder();

    for (int i = words.length - 1; i >= 0; i--) {
      if(!words[i].equals(""))
        sb.append(words[i] + " ");
    }

    return sb.toString().trim();
  }
}
