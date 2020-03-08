// Shortest Word Distance III 最短单词距离 III

@MEDIUM
public class LC245 {

	@Array
	public int shortestWordDistance(String[] words, String word1, String word2) {
    int shortest = words.length;
    
    // word1 = word2
    if (word1.equals(word2)) {
      int p = -1;
      for (int i = 0; i < words.length; i++) {
        String tmp = words[i];
        
        if (word1.equals(tmp)) {
          if (p != -1) shortest = Math.min(shortest, i - p);
          p = i;
        }
      }
      return shortest;
    }
    
    // word1 != word2
    int p1 = -1;
    int p2 = -1;
    
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      
      if (word.equals(word1)) {
        p1 = i;
      }

      if (word.equals(word2)) {
        p2 = i;
      }

      if (p1 != -1 && p2 != -1) {
        shortest = Math.min(shortest, Math.abs(p1 - p2));
      }
    }
    
    return shortest;
  }
}
