// Sort Array By Parity 按奇偶排序数组

@EASY
public class LC905 {

	@Array
	public int[] sortArrayByParity(int[] A) {
    int left = 0;
    int right = A.length - 1;

    while (left < right) {
      while (left < right && A[left] % 2 == 0) left++;
      while (left < right && A[right] % 2 == 1) right--;

      if (left < right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
        left++;
        right--;
      }
    }

    return A;
  }
}
