// Graph Valid Tree

@MEDIUM
@Google
class LC261 {

  @BFS
  public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1) return false;

  }

  @UnionFind
  public boolean validTree2(int n, int[][] edges) {
    if (edges.length != n - 1) return false;

    DisjointSet set = new DisjointSet(n);

    for (int[] edge : edges) {
      set.union(edge[0], edge[1]);
    }

    return set.size == 1;
  }

  class DisjointSet {
    int size;
    int[] parent;

    DisjointSet(int size) {
      this.size = size;
      parent = new int[size];

      for (int i = 0; i < size; i++)
        parent[i] = i;
    }

    private void union(int a, int b) {
      int ap = find(a);
      int bp = find(b);
      if (ap != bp) {
        parent[ap] = bp;
        size--;
      }
    }

    private int find(int a) {
      while (a != parent[a])
        a = parent[a];
      return a;
    }
  }
}