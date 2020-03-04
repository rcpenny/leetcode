// Insert Delete GetRandom O(1) - Duplicates allowed O(1) 时间插入、删除和获取随机元素 - 允许重复

@HARD
public class LC381 {}

@LinkedHashSet
class RandomizedCollection {
  List<Integer> list;
  Map<Integer, Set<Integer>> numToIndexes;
  Random rand;

  public RandomizedCollection() {
    this.list = new ArrayList<>();
    this.numToIndexes = new HashMap<>();
    this.rand = new Random();
  }

  public boolean insert(int val) {
    if (!numToIndexes.containsKey(val)) {
      numToIndexes.put(val, new LinkedHashSet<>());
    }

    // 加入这个数字的index
    numToIndexes.get(val).add(list.size());
    list.add(val);
    
    return numToIndexes.get(val).size() == 1;
  }

  public boolean remove(int val) {
    if (!numToIndexes.containsKey(val) || numToIndexes.get(val).size() == 0) {
      return false;
    }

		// 移除这个number对应indexes中头部的那个
    int removeIndex = numToIndexes.get(val).iterator().next();
    numToIndexes.get(val).remove(removeIndex);
		
		// 把最后一个数字放进进移除的位置
    int lastVal = list.get(list.size() - 1);
    list.set(removeIndex, lastVal);
		
		// 更新map
    numToIndexes.get(lastVal).add(removeIndex);
    numToIndexes.get(lastVal).remove(list.size() - 1); // remove the lastIndex number. not the last number
    
		list.remove(list.size() - 1);
		if (numToIndexes.get(val).size() == 0) {
      numToIndexes.remove(val);
    }
    
    return true;
  }

  public int getRandom() {
    int randomIndex = rand.nextInt(list.size());
    return list.get(randomIndex);
  }
}
