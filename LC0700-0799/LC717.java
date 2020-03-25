// 1-bit and 2-bit Characters 1比特与2比特字符

@EASY
public class LC717 {
	public boolean isOneBitCharacter(int[] bits) {
		int i = 0;

		while (i < bits.length - 1)
			i += bits[i] + 1;

		return i == bits.length - 1;
  }
}
