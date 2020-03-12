// Course Schedule II	课程表 II

@MEDIUM
public class LC210 {

  @TopologicalSorting
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer> order = new ArrayList<>();

    int[] indegrees = new int[numCourses];

    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int[] prep : prerequisites) {
      int prev = prep[1];
      int follow = prep[0];
      indegrees[follow]++;
      map.get(prev).add(follow);
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegrees[i] == 0) queue.offer(i);
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      order.add(cur);
      count++;

      for (int follow : map.get(cur)) {
        indegrees[follow]--;
        if (indegrees[follow] == 0) {
          queue.offer(follow);
        }
      }
    }

    if (count != numCourses) return new int[] {};

    int[] result = new int[order.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = order.get(i);
    }

    return result;
  }
}
