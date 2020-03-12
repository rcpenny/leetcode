// Ugly Number II 丑数 II

@MEDIUM
public class LC264 {

	@Heap
  public int nthUglyNumber(int n) {
    PriorityQueue<Long> pq = new PriorityQueue<Long>();
    Set<Long> set = new HashSet<Long>();
    
    Long[] primes = new Long[3];
    primes[0] = Long.valueOf(2);
    primes[1] = Long.valueOf(3);
    primes[2] = Long.valueOf(5);
    
    for (int i = 0; i < 3; i++) {
      pq.offer(primes[i]);
      set.add(primes[i]);
    }
    
    Long number = Long.valueOf(1);
    for (int i = 1; i < n; i++) {
      number = pq.poll();
      
      for (int j = 0; j < 3; j++) {
        if (!set.contains(primes[j] * number)) {
          pq.offer(primes[j] * number);
          set.add(primes[j] * number);
        }
      }
    }
    
    return number.intValue();
  }

}
