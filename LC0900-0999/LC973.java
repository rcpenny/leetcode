// K Closest Points to Origin

@MEDIUM
@Google
public class LC973 {

	@Heap
	public int[][] kClosest(int[][] points, int K) {
		int[][] result = new int[K][2];

		PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> {
			return getDistance(a) - getDistance(b) < 0 ? -1 : 1;
		});

		for (int[] p : points) {
			minheap.offer(p);
		}

		for (int i = 0; i < K; i++) {
			result[i] = minheap.poll();
		}
		
		return result;
	}

	private double getDistance(int[] points) {
		return Math.sqrt(points[0] * points[0] + points[1] * points[1]);
	}
}
