// Partition Array Into Three Parts With Equal Sum 将数组分成和相等的三个部分

@EASY
public class LC1013 {

  @PrefixSum
  public boolean canThreePartsEqualSum(int[] A) {
    int n = A.length;
    int[] prefix = new int[n];
    
		prefix[0] = A[0];
    for (int i = 1; i < n; i++) prefix[i] += A[i] + prefix[i - 1];

    if (prefix[n - 1] % 3 != 0) return false;
		int third = prefix[n - 1] / 3;

    for (int i = 0; i < n - 2; i++) {
      if (prefix[i] != third) continue;

      for (int j = i + 1; j < n - 1; j++) {
        if (prefix[j] - prefix[i] != third) continue;

        return true;
      }
    }

    return false;
	}
}
