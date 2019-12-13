// Clone Graph

@MEDIUM
public class LC133 {

	@Graph
	@BFS
  public Node cloneGraph(Node node) {
		Map<Node, Node> map = new HashMap<>();
		map.put(node, new Node(node.val, new ArrayList<>()));

		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();

			for (Node neighbor : tmp.neighbors) {
				if (!map.containsKey(neighbor)) {
					map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
					queue.offer(neighbor);
				}
			}
		}

		for (Node origin : map.keySet()) {
			Node copy = map.get(origin);

			for (Node neighbor : origin.neighbors) {
				copy.neighbors.add(map.get(neighbor));
			}
		}

		return map.get(node);
	}
}

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {}

	public Node(int _val,List<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
	}
}
