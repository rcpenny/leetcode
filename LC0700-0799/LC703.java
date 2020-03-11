// Kth Largest Element in a Stream 数据流中的第K大元素

@EASY
public class LC703 {}

@Heap
class KthLargest {
  int k;
  PriorityQueue<Integer> minheap;
  
  public KthLargest(int k, int[] nums) {
    this.k = k;
    minheap = new PriorityQueue<>();
      
    for(int n : nums) {
      minheap.add(n);
      if(minheap.size() > k) minheap.poll();
    }
  }
  
  public int add(int val) {
    minheap.add(val);
    
    if(minheap.size() == k + 1)
      minheap.poll();
    
    return minheap.peek();
  }
}
