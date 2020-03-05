// Text Justification 文本左右对齐

@HARD
class LC68 {

	@String
	public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> text = new ArrayList<>();

    if (words == null || words.length == 0) {
      return text;
    }

    int curLen = 0;
    List<String> curWords = new ArrayList<>();

    for (String word : words) {

      // 1. don't assemble words, add words greedyly to a line
      if (curWords.isEmpty() || curLen + curWords.size() + word.length() <= maxWidth) {
        curWords.add(word);
        curLen += word.length();
        continue;
      }

      // 2. assemable words
      int spaceCount = maxWidth - curLen;
      int interval = curWords.size() - 1;
      StringBuilder sb = new StringBuilder();

        // only 1 word
      if (interval == 0) {
        sb.append(curWords.get(0));
        for (int i = 0; i < spaceCount; i++) sb.append(" ");
      }

        // more than 1 word
      else {
        int extrasSpace = spaceCount % interval;
        int spaceEachInterval = spaceCount / interval;

        String spaces = "";
        for (int k = 0; k < spaceEachInterval; k++) {
          spaces += " ";
        }

        sb.append(curWords.get(0));

        for (int j = 1; j < curWords.size(); j++) {
          sb.append(spaces);
          if (extrasSpace != 0) {
            sb.append(" ");
            extrasSpace--;
          }
          sb.append(curWords.get(j));
        }
      }


      // 3. after assemble, add line to text,
      text.add(sb.toString());
      curLen = word.length();
      curWords.clear();
      curWords.add(word);
    }


    // take care of last line
    StringBuilder sb = new StringBuilder();
    sb.append(curWords.get(0));

    for (int j = 1; j < curWords.size(); j++) {
      sb.append(" ");
      sb.append(curWords.get(j));
    }

    while (sb.length() < maxWidth) {
      sb.append(" ");
    }
    text.add(sb.toString());

    return text;
  }
}
