// Find K Pairs with Smallest Sums 查找和最小的K对数字

@MEDIUM
public class LC373 {

	@HEAP
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> answer = new ArrayList<>();
			
		if(nums1.length == 0 || nums2.length == 0 || k == 0) return answer;

		PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> {
			return a.get(0) + a.get(1) - b.get(0) - b.get(1);
		});
			
			for(int num1: nums1){
				for(int num2: nums2){
					List<Integer> tmp = new ArrayList<>();
					tmp.add(num1);
					tmp.add(num2);
					pq.add(tmp);
				}
			}

		while(!pq.isEmpty() && k > 0){
			answer.add(pq.poll());
			k--;
		}
		
		return answer;
	}
}
