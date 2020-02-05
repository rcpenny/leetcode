// Partition Array Into Three Parts With Equal Sum 将数组分成和相等的三个部分

@EASY
public class LC1013 {

  @Array
  public boolean canThreePartsEqualSum(int[] A) {
    int sum = Arrays.stream(A).sum();
    if (sum % 3 != 0) return false;

    int curSum = 0;
    int count = 0;

    for (int i = 0; i < A.length; i++) {
      curSum += A[i];
      if (curSum == sum / 3) {
        curSum = 0;
        count++;
      }
    }

    return count == 3;
  }
}