// Course Schedule 课程表

@MEDIUM
public class LC207 {

	@TopologicalSorting
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		
		Map<Integer, List<Integer>> preToFollow = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			preToFollow.put(i, new ArrayList<>());
		}

		for (int[] pair : prerequisites) {
			preToFollow.get(pair[1]).add(pair[0]);
			indegree[pair[0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++)
			if (indegree[i] == 0) queue.offer(i);

		int coursesLeft = numCourses;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			coursesLeft--;

			for (int follow : preToFollow.get(course)) {
				if (--indegree[follow] == 0) {
					queue.offer(follow);
				}
			}
		}

		return coursesLeft == 0;
	}
}
