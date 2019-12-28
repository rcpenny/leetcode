// Fruits into Baskets

@MEDIUM
@Google
public class LC904 {

  @TwoPointers
  @SlidingWindow
  public int totalFruit(int[] tree) {
    int max = 1;

    int fast = 0;
    int slow = 0;
    
    int fruit = 0;
    int n = tree.length;

    Map<Integer, Integer> map = new HashMap<>();

    while (fast < n && slow < n) {

      if (map.size() <= 2) {
        fruit = tree[fast];
        map.put(fruit, map.getOrDefault(fruit, 0) + 1);
        
        if (map.size() <= 2) {
          max = Math.max(max, fast - slow + 1);
        }

        fast++;
        continue;
      }

      fruit = tree[slow];
      if (map.get(fruit) == 1) map.remove(fruit);
      else map.put(fruit, map.get(fruit) - 1);
      slow++;
    }

    return max;
  }
}