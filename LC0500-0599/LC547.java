// Friends Cricle 朋友圈

public class LC547 {

  @UnionFind
  public int findCircleNum(int[][] M) {
    int n = M.length;
    FriendCircle fc = new FriendCircle(n);

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (M[i][j] == 1)
          fc.connectFriends(i, j);

    return fc.circleCount;
  }
}

class FriendCircle {
  int circleCount;
  int[] circleLeader;

  FriendCircle(int N) {
    circleCount = N;
    circleLeader = new int[N];
    
    for (int i = 0; i < N; i++) {
      circleLeader[i] = i;
    }
  }

  void connectFriends(int a, int b) {
    int aLeader = findLeader(a);
    int bLeader = findLeader(b);

    if (aLeader != bLeader) {
      circleLeader[aLeader] = bLeader;
      circleCount--;
    }
  }

  private int findLeader(int a) {
    while (circleLeader[a] != a)
      a = circleLeader[a];
    return a;
  }
}