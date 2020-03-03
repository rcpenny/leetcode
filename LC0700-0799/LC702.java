// Search in a Sorted Array of Unknown Size 搜索长度未知的有序数组

@MEDIUM
public class LC702 {
	
	@BinarySearch
	public int search(ArrayReader reader, int target) {
    if (target < reader.get(0)) return -1;

    int end = 1;
    while (reader.get(end) < target) 
      end = end * 2;

    int start = end / 2;

    while (start + 1 < end) {
      int middle = start + (end - start) / 2;
      if (reader.get(middle) >= target) end = middle;
      else start = middle;
    }

    if (reader.get(start) == target) return start;
    if (reader.get(end) == target) return end;

    return -1;
  }
}
