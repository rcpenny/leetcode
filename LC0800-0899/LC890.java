// Find and Replace Pattern 查找和替换模式

@MEDIUM
public class LC890 {
	
	@HashTable
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> results = new ArrayList<>();
		
		Map<Character, Character> w2p = new HashMap<>();
		Map<Character, Character> p2w = new HashMap<>();

		for (String word : words) {
			if (word.length() != pattern.length()) continue;

			w2p.clear();
			p2w.clear();

			boolean match = true;
			for (int i = 0; i < word.length(); i++) {
				char w = word.charAt(i);
				char p = pattern.charAt(i);

				if (!w2p.containsKey(w) && !p2w.containsKey(p)) {
					w2p.put(w, p);
					p2w.put(p, w);
					continue;
				}

				if (w2p.containsKey(w) && w2p.get(w) == p 
					&& p2w.containsKey(p) && p2w.get(p) == w) {
					continue;
				}

				match = false;
				break;
			}
			if (match) results.add(word);
		}

		return results;
	}
}
