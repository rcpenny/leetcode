// Beautiful Arrangement 优美的排列

@MEDIUM
public class LC526 {
  private int count = 0;

  public int countArrangement(int N) {
    int[] array = new int[N];
    for (int i = 0; i < N; i++) array[i] = i + 1; 
    boolean[] visited = new boolean[N];

    dfs(array, 0, visited, new ArrayList<>());

    return count;
  }

  // 定义： 元数据array(1-N)  控制index(为了查beatiful)，visited(为排列)   状态arrange 
  private void dfs(int[] array, int index, boolean[] visited, List<Integer> arrange) {
    // 出口：合理arrangement出现
    if (arrange.size() == array.length) {
      count++;
      return;
    }

    // 拆解：1-N一个个扫
    for (int i = 0; i < array.length; i++) {
      // 进入递归的条件：数字没选过，符合beatiful
      if (visited[i]) continue;
      if (!beautiful(array[i], index + 1)) continue;

      visited[i] = true;
      arrange.add(array[i]);
      dfs(array, index + 1, visited, arrange);
      visited[i] = false;
      arrange.remove(arrange.size() - 1);
    }
  }

  private boolean beautiful(int number, int position) {
    if (number % position == 0) return true;
    if (position % number == 0) return true;
    return false;
  }
}
