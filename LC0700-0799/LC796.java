// Rotate String 旋转字符串

@EASY
public class LC796 {

	// https://leetcode-cn.com/problems/rotate-string/solution/xuan-zhuan-zi-fu-chuan-by-leetcode/
	// Rabin-Karp, KMP
	@String
	public boolean rotateString(String A, String B) {
    return A.length() == B.length() && (A + A).contains(B);
  }
}
