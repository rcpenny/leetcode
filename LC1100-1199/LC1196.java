// How Many Apples Can You Put into the Basket 最多可以买到的苹果数量

@EASY
public class LC1196 {
  
	@Greedy
	public int maxNumberOfApples(int[] arr) {
    int weight = 0;
    int i = 0;
    
    Arrays.sort(arr);

    for (i = 0; i < arr.length; i++) {
      weight += arr[i];
      if (weight > 5000) break; 
    }

    return i;
  }
}
