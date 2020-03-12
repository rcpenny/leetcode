// Word Search II 单词搜索 II 

@HARD
public class LC212 {

  @Trie
  @Backtracking
  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();

    TrieNode root = new TrieNode();

    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        TrieNode tmp = root;
        char c = word.charAt(i);

        if (tmp.children[c - 'a'] == null) {
          tmp.children[c - 'a'] = new TrieNode(c);
        }
        tmp = tmp.children[c - 'a'];

        if (i == word.length() - 1) {
          tmp.word = word;
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        search(board, i, j, root, result);
      }
    }

    return result;
  }

  private void search(char[][] board, int x, int y, TrieNode node, List<String> result) {

  }

  class TrieNode {
    char c;
    String word;
    TrieNode[] children;

    TrieNode(char c) {
      this.c = c;
      children = new TrieNode[26];
    }
  }
}
