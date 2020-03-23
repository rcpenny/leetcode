// Sort Array By Parity II 按奇偶排序数组 II

@EASY
public class LC922 {

	@Array
  public int[] sortArrayByParityII(int[] A) {
    int evenIndex = 0;
    int oldIndex = 1;

    int[] result = new int[A.length];

    for (int i = 0; i < A.length; i++) {
      if (A[i] % 2 == 0) {
        result[evenIndex] = A[i];
        evenIndex += 2;
      } else {
        result[oldIndex] = A[i];
        oldIndex += 2;
      }
    }

    return result;
  }
}
