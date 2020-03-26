// Relative Sort Array 数组的相对排序

@EASY
public class LC1122 {
	
	@Array
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new TreeMap<>();
    
    for (int num : arr1) {
      if (!map.containsKey(num)) map.put(num, 1);
      else map.put(num, map.get(num) + 1);
    }

    int[] result = new int[arr1.length];

    int index = 0;
    for (int num : arr2) {
      int freq = map.get(num);
      for (int i = 0; i < freq; i++)
        result[index++] = num;
      map.remove(num);
    }

    for (int num : map.keySet()) {
      int freq = map.get(num);
      for (int i = 0; i < freq; i++)
        result[index++] = num;
    }

    return result;
  }
}
