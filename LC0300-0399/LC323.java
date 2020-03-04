// Number of Connected Components in an Undirected Graph 无向图中连通分量的数目

@MEDIUM
public class LC323 {
  
	@UnionFind
	public int countComponents(int n, int[][] edges) {
    if (n <= 0) {
      return 0;
    }

    UnionFind uf = new UnionFind(n);

    for (int[] edge : edges) {
      uf.union(edge[0], edge[1]);
    }

    return uf.componentsCount;
  }

  class UnionFind {
    int componentsCount;
    int[] uf;

    UnionFind(int size) {
      this.componentsCount = size;
      this.uf = new int[size];

      for (int i = 0; i < size; i++) {
        this.uf[i] = i;
      }
    }

    public void union(int a, int b) {
      int pa = find(a);
      int pb = find(b);

      if (pa != pb) {
        uf[pa] = pb;
        componentsCount--;
      }
    }

    public int find(int a) {
      while (uf[a] != a) {
        a = uf[a];
      }
      return a;
    }
  }
}
