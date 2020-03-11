// Last Stone Weight 最后一块石头的重量

@EASY
public class LC1046 {

	@Heap
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

    for (int s : stones) maxheap.offer(s);

    while (maxheap.size() > 1) {
      int x = maxheap.poll();
      int y = maxheap.poll();

      if (x != y) maxheap.offer(Math.abs(x - y));
    }

    return maxheap.size() == 1 ? maxheap.poll() : 0;
  }
}
