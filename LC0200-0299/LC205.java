// Isomorphic Strings

@EASY
public class LC205 {
  
  @HashTable
  public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> s2t = new HashMap<>();
		Map<Character, Character> t2s = new HashMap<>();

		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();

		int n = sc.length;

		for (int i = 0; i < n; i++) {
			char scc = sc[i];
			char tcc = tc[i];

			if (!s2t.containsKey(scc) && !t2s.containsKey(tcc)) {
				s2t.put(scc, tcc);
				t2s.put(tcc, scc);
				continue;
			}

			if (s2t.containsKey(scc) && t2s.containsKey(tcc)) {
				if (s2t.get(scc) != tcc || t2s.get(tcc) != scc) {
					return false;
				}
				continue;
			}

			return false;
		}

		return true;
  }
}