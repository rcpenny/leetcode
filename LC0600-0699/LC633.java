// Sum of Square Numbers 平方数之和

@EASY
class Solution {
  
	@Math
	public boolean judgeSquareSum(int num) {
    if (num < 0) return false;
    
    for (int a = (int) Math.sqrt(num); a >= 0; a--) {
      if (a * a == num) return true;

      int comp = num - a * a;
      int b = (int) Math.sqrt(comp);

      if (b * b == comp) return true;
    }

    return false;
  }
}
