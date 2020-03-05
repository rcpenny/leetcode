// Can Place Flowers 种花问题

@EASY
public class LC605 {

	@Array
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		int i = 0;

		while (i < flowerbed.length) {
			// 检查是否种满花了
		  if (count >= n) return true;

			// 是花就跳2步
			if (flowerbed[i] == 1) {
				i += 2;
				continue;
			}

			// 不是花，check左
			if (i > 0 && flowerbed[i - 1] == 1) {
				i += 1;
				continue;
			}

			// 不是花，check右
			if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
				i += 3;
				continue;
			}

			// 可种
			flowerbed[i] = 1;
			i += 2;
			count++;
		}

		// last check
		return count >= n;
	}
}
