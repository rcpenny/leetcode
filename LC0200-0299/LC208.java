// Implement Trie (Prefix Tree) 实现 Trie (前缀树)

@MEDIUM
public class LC208 {}

@Trie
public class Trie {

  TrieNode root;

  public Trie() {
    root = new TrieNode(' ');
  }

  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode(c);
      }
      node = node.children[c - 'a'];
    }
    node.isWord = true;
  }

  public boolean search(String word) {
    TrieNode node = root;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.children[c - 'a'] == null) {
        return false;
      }
      node = node.children[c - 'a'];
    }

    return node.isWord;
  }
  
  public boolean startsWith(String prefix) {
    TrieNode node = root;

    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (node.children[c - 'a'] == null) {
        return false;
      }
      node = node.children[c - 'a'];
    }

    return true;
  }

  class TrieNode {
    char c;
    boolean isWord;
    TrieNode[] children;

    TrieNode(char c) {
      this.c = c;
      this.isWord = false;
      this.children = new TrieNode[26];
    }
  }
}
