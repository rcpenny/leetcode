// Find Median from Data Stream 数据流的中位数

@HARD
public class LC295 {}

@Heap
class MedianFinder {
  
	// maxheap存小数堆，minheap存大数堆
  PriorityQueue<Integer> maxheap;
  PriorityQueue<Integer> minheap;

  public MedianFinder() {
    maxheap = new PriorityQueue<>(Collections.reverseOrder());
    minheap = new PriorityQueue<>();
  }
  
  public void addNum(int num) {
    maxheap.offer(num);
		minheap.offer(maxheap.poll());

		while (minheap.size() > maxheap.size())
			maxheap.offer(minheap.poll());
  }

  public double findMedian() {
    return maxheap.size() == minheap.size() 
      ? (maxheap.peek() + minheap.peek()) / 2.0 
      : 1.0 * maxheap.peek();
  }
}
