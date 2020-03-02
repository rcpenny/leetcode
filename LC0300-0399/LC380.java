// Insert Delete GetRandom O(1) 数时间插入、删除和获取随机元素

@MEDIUM
public class LC380 {}

@HashTable
@Design
class RandomizedSet {

	List<Integer> list;
	Map<Integer, Integer> map;
	Random rand;

	public RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<>();
		rand = new Random();
	}
	
	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (map.containsKey(val)) return false;

		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!map.containsKey(val)) return false;

		int lastIndex = list.size() - 1;
		int lastVal = list.get(lastIndex);

		int valIndex = map.get(val);
		
		map.put(lastVal, valIndex);
		list.set(valIndex, lastVal);

		list.remove(lastIndex);
		map.remove(val);

		return true;
	}
	
	/** Get a random element from the set. */
	public int getRandom() {
		int index = rand.nextInt(list.size());
		return list.get(index);
	}
}
