// Product of Array Except Self 除自身以外数组的乘积

@MEDIUM
public class LC238 {

  @Array
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    
    int mul = 1;
    
    for (int i = 0; i < nums.length; i++) {
      result[i] = mul;
      mul = nums[i] * mul;
    }

    mul = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] = mul * result[i];
      mul = mul * nums[i];
    }
    
    return result;
  }
}