// Kth Largest Element in a Stream 数据流中的第K大元素

@EASY
public class LC703 {}

@Heap
class KthLargest {
  PriorityQueue<Integer> minheap;

  public KthLargest(int k, int[] nums) {
    minheap = new PriorityQueue<>();

    for (int n : nums) {
      if (minheap.size() < k) {
        minheap.offer(n);
        continue;
      }
        
      if (n > minheap.peek()) {
        minheap.poll();
        minheap.offer(n);
      }
    }
  }
  
  public int add(int val) {
    if (val > minheap.peek()) {
      minheap.poll();
      minheap.offer(val);
    }
    return minheap.peek();
  }
}
