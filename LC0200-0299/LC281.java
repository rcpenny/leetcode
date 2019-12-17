// Zigzag Iterator

@MEDIUM
class LC281 {}

@IteratorDesign
public class ZigzagIterator {
	private Queue<Integer> v1;
	private Queue<Integer> v2;
	boolean upper;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.v1 = new LinkedList<>(v1);
		this.v2 = new LinkedList<>(v2);

		upper = true;
	}

	public int next() {
		if (!v1.isEmpty() && !v2.isEmpty()) {
      int head = upper ? v1.poll() : v2.poll();
			upper = !upper;
      return head;
		}

		return !v1.isEmpty() ? v1.poll() : v2.poll();
	}

	public boolean hasNext() {
		return !v1.isEmpty() || !v2.isEmpty();
	}
}
