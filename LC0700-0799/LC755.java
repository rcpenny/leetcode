// Pour Water 倒水

@HARD
public class LC755 {

	@Array
  public int[] pourWater(int[] heights, int V, int K) {
    if (heights == null || heights.length == 0 || V == 0) return heights;
    
    for (int m = 0; m < V; m++) {
      int lowest_index = K;
      
      // 向左搜
      for (int i = K - 1; i >= 0; i--) {
        if (heights[i] > heights[lowest_index]) break;
        if (heights[i] < heights[lowest_index]) lowest_index = i;
        // if heights[i] == heights[lowest_index] 保持原最低点lowest_index
      }
      
      if (lowest_index < K) {
        heights[lowest_index]++;
        continue;
      }
			
			lowest_index = K;
      // 向右搜
      for (int i = K + 1; i < heights.length; i++) {
        if (heights[i] > heights[lowest_index]) break;
        if (heights[i] < heights[lowest_index]) lowest_index = i;
        // if heights[i] == heights[lowest_index], 保持原最低点lowest_index
			}
			
			if (lowest_index > K) {
				heights[lowest_index]++;
        continue;
			}

			// self add one height
      heights[K]++;
    }

    return heights;
  }
}
