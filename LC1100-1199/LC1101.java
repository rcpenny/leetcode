// The Earliest Moment When Everyone Become Friends 彼此熟识的最早时间

@MEDIUM
public class LC1101 {

	@UnionFind
	public int earliestAcq(int[][] logs, int N) {
    Arrays.sort(logs, (a, b) -> {
			return a[0] - b[0];
		});

    Friends f = new Friends(N);

    for (int[] record : logs) {
      f.union(record[1], record[2]);
      if (f.circles == 1) return record[0];
    }

    return -1;
  }
}

class Friends {
  int circles;
  int[] leader;

  Friends(int N) {
    circles = N;
    leader = new int[N];

    for (int i = 0; i < N; i++) {
      leader[i] = i;
    }
  }

  void union(int A, int B) {
    int ALeader = find(A);
    int BLeader = find(B);

    if (ALeader != BLeader) {
      leader[ALeader] = BLeader;
      circles--;
    }
  }

  private int find(int A) {
    while (leader[A] != A) {
      A = leader[A];
    }
    return A;
  }
}
