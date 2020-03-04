// Is Graph Bipartite? 判断二分图

@MEDIUM
public class LC785 {
	
	@BFS
	public boolean isBipartite(int[][] graph) {
		int n = graph.length;

		int[] colors = new int[n];
		Arrays.fill(colors, -1);

		for(int i = 0; i < graph.length; i++)
			if(colors[i] == -1)
				if (!isMatchingTheRules(i, colors, graph))
					return false;

		
		return true;
	}

	private boolean isMatchingTheRules(int i, int[] colors, int[][] graph) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);

		colors[i] = 0;
		
		while(!queue.isEmpty()) {
			int indexOfNode = queue.poll();
			int[] neighbors = graph[indexOfNode];
			
			for(int nei : neighbors) {
				if(colors[nei] != -1) {
					if(colors[nei] == colors[indexOfNode]) return false;
				} else {
					colors[nei] = 1 - colors[indexOfNode];
					queue.offer(nei);
				}
			}
		}
		
		return true;
	}
}
