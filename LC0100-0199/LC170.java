// Two Sum III - Data structure design 两数之和 III - 数据结构设计

@EASY
public class LC170 {}

@HashTable
public class TwoSum3 {
  Map<Integer, Integer> numToFreq;

  public TwoSum() {
    this.numToFreq = new HashMap<>();
  }
  
  public void add(int number) {
    numToFreq.putIfAbsent(number, 0);
    numToFreq.put(number, numToFreq.get(number) + 1);
  }
  
  public boolean find(int value) {
    for (int number : numToFreq.keySet()) {
			int complement = value - number;

			if (complement != number && numToFreq.containsKey(complement)) {
        return true;
      }

      if (complement == number && numToFreq.get(complement) > 1) {
        return true;
      }
    }
    return false;
  }
}
