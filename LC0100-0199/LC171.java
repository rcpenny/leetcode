// Excel Sheet Column Number Excel表列序号

@EASY
class LC171 {

  @Math
  public int titleToNumber(String s) {
    char[] ch = s.toCharArray();
    int num = 0;

    for (char c : ch)
      num = num * 26 + (c - 'A') + 1;

    return num;
  }
}
