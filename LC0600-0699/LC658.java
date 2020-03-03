// Find K Closest Elements 找到 K 个最接近的元素

@MEDIUM
public class LC658 {

	@BinarySearch
	@TwoPointers	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int[] closest = new int[k];
    
    int start = 0;
    int end = arr.length - 1;
    
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] >= x) end = mid;
      else start = mid;
    }
    
    for (int i = 0; i < k; i++) {
      if (start < 0) {
        closest[i] = arr[end++];
        continue;
      }
      
      if (end >= arr.length) {
        closest[i] = arr[start--];
        continue;
      }
      
      int diff_start = Math.abs(arr[start] - x);
      int diff_end = Math.abs(arr[end] - x);
      
      closest[i] = diff_start <= diff_end ? arr[start--] : arr[end++];
    }
    
    Arrays.sort(closest);
    
    List<Integer> result = new ArrayList<>();
    for (int n : closest) result.add(n);
    
    return result;
  }
}
