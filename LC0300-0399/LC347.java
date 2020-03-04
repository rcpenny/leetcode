// Top K Frequent Elements 前 K 个高频元素

@MEDIUM
public class LC347 {

  @Heap
  public List<Integer> topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> {
      return b.getValue() - a.getValue();
    });

    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      heap.offer(e);
    }

    List<Integer> result = new ArrayList<>();
    while (k-- > 0) result.add(heap.poll().getKey());
    
    return result;
  }
}
