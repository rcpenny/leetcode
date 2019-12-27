// Find the Town Judge

@EASY
public class LC997 {

  @Graph
  public int findJudge(int N, int[][] trust) {
    int[][] graph = new int[N + 1][N + 1];
    
    for (int[] t : trust)
      graph[t[0]][t[1]] = 1;

    int judge = 1;

    for (int i = 2; i <= N; i++)
      if (graph[i][judge] != 1)
        judge = i;

    for (int i = 1; i <= N; i++)
      if (i != judge && (graph[i][judge] != 1 || graph[judge][i] == 1))
        return -1;

    return judge;
  }
}