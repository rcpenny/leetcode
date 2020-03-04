// All O`one Data Structure 全 O(1) 的数据结构

@HARD
public class LC432 {}

class Bucket {
	int freq;
	Set<String> keySet;

	Bucket prev;
	Bucket next;

	public Bucket(int cnt) {
		this.freq = cnt;
		this.keySet = new HashSet<>();
	}
}

// don't seperate out another BucketList, AllOne itself is actually a linked Bucket list
// bucket list should remain freq increasing order

public class AllOne {
	// maintain bucket list
	Bucket head;
	Bucket tail;

	// use two map. 核心：key to freq, freq to buckets
	Map<String, Integer> keyToFreq;
	Map<Integer, Bucket> freqToBucket;

	public AllOne() {
		this.head = new Bucket(Integer.MIN_VALUE);
		this.tail = new Bucket(Integer.MAX_VALUE);

		this.head.next = tail;
		this.tail.prev = head;

		this.keyToFreq = new HashMap<>();
		this.freqToBucket = new HashMap<>();
	}
	
	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		if (keyToFreq.containsKey(key)) {
			changeKey(key, 1);
		} else {
			keyToFreq.put(key, 1);
			if (!freqToBucket.containsKey(1)) {
				addBucketAfter(new Bucket(1), head);
			}
			head.next.keySet.add(key);
			freqToBucket.put(1, head.next);
		}
	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) {
		if (keyToFreq.containsKey(key)) {
			int freq = keyToFreq.get(key);
			if (freq == 1) {        //如果刚好为1，移除即可
				keyToFreq.remove(key);
				removeKeyFromBucket(freqToBucket.get(freq), key);
			} else {
				changeKey(key, -1);		//执行-1操作
			}
		}
	}
	
	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		if (tail.prev == head) return "";
		return (String) tail.prev.keySet.iterator().next();
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		if (head.next == tail) return "";
		return (String) head.next.keySet.iterator().next();        
	}


	/** HELPER PRIVATE METHODS */

	private void changeKey(String key, int offset) {  
		int freq = keyToFreq.get(key);
		keyToFreq.put(key, freq + offset);
		
		Bucket curBucket = freqToBucket.get(freq);
		Bucket newBucket;

		if (freqToBucket.containsKey(freq + offset)) {
			newBucket = freqToBucket.get(freq + offset);
		} else {
			newBucket = new Bucket(freq + offset);
			freqToBucket.put(freq + offset, newBucket);
			addBucketAfter(newBucket, offset == 1 ? curBucket : curBucket.prev);
		}
		newBucket.keySet.add(key);
		removeKeyFromBucket(curBucket, key);
	}
	
	private void removeKeyFromBucket(Bucket bucket, String key) {
		bucket.keySet.remove(key);
		if (bucket.keySet.size() == 0) {
			removeBucketFromList(bucket);
			freqToBucket.remove(bucket.freq);
		}
	}

	private void removeBucketFromList(Bucket bucket) {
		bucket.prev.next = bucket.next;
		bucket.next.prev = bucket.prev;
		bucket.next = null; // for better garbage collection
		bucket.prev = null;
	}

	private void addBucketAfter(Bucket newBucket, Bucket prevBucket) {
		newBucket.prev = prevBucket;
		newBucket.next = prevBucket.next;
		prevBucket.next.prev = newBucket;
		prevBucket.next = newBucket;
	}
}
