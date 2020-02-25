// Maximum Product Subarray 乘积最大子序列

@MEDIUM
public class LC152 {
  
  @DynamicProgramming
  public int maxProduct(int[] nums) {
    if (nums.length == 1) return nums[0];
    
    int n = nums.length;
    
    // 可以优化至O(1)
    int[] pos = new int[n];
    int[] neg = new int[n];
    
    pos[0] = Math.max(nums[0], 0);
    neg[0] = Math.min(nums[0], 0);
    
    int max = pos[0];
    
    for (int i = 1; i < n; i++) {
      int cur = nums[i];
      
      if (cur == 0) {
        pos[i] = 0;
        neg[i] = 0;
      }
      
      else if (cur > 0) {
        pos[i] = Math.max(pos[i - 1] * cur, cur);
        neg[i] = neg[i - 1] * cur;
      }
      
      else if (cur < 0) {
        pos[i] = neg[i - 1] * cur;
        neg[i] = Math.min(pos[i - 1] * cur, cur);
      }
      
      max = Math.max(max, pos[i]);
    }
    
    return max;
  }
}
