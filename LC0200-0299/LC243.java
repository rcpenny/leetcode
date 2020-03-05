// Shortest Word Distance 最短单词距离

@EASY
public class LC243 {

	@Array
  public int shortestDistance(String[] words, String word1, String word2) {
    int p1 = -1;
    int p2 = -1;
    int shortest = words.length;
    
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
