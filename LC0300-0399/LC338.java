// Counting Bits 比特位计数

@MEDIUM
public class LC338 {

	@DP
  public int[] countBits(int num) {
    int[] bits = new int[num + 1];
    bits[0] = 0;

    for (int i = 1; i <= num; i++)
      bits[i] = bits[i / 2] + i % 2;

    return bits;
  }
}
