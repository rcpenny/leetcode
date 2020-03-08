// Bomb Enemy 轰炸敌人

@MEDIUM
public class LC361 {

	@DP
	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length, n = grid[0].length;

		int[][] up = new int[m][n]; // 该点向上走，可炸死的人
		int[][] down = new int[m][n];
		int[][] left = new int[m][n];
		int[][] right = new int[m][n];

		int i, j;

		// up, last row向上
		for (i = m - 1; i >= 0; i--) {
			for (j = 0; j < n; j++) {
			  up[i][j] = 0;
				if (grid[i][j] == 'W') continue; // 是wall,此点向上均为0
				if (grid[i][j] == 'E') up[i][j] = 1;

				// 不在最后一排
				if (i != m - 1) up[i][j] += up[i + 1][j]; 
			}
		}

		// down, first row向下
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
			  down[i][j] = 0;
				if (grid[i][j] == 'W') continue;
				if (grid[i][j] == 'E') down[i][j] = 1;
				if (i != 0) down[i][j] += down[i - 1][j];
			}
		}

		// left，first column向左
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
			  left[i][j] = 0;
				if (grid[i][j] == 'W') continue;
				if (grid[i][j] == 'E') left[i][j] = 1;
				if (j != 0) left[i][j] += left[i][j - 1];
			}
		}

		// right，last column向右
		for (i = 0; i < m; i++) {
			for (j = n - 1; j >= 0; j--) {
			  right[i][j] = 0;
				if (grid[i][j] == 'W') continue;
				if (grid[i][j] == 'E') right[i][j] = 1;
				if (j != n - 1) right[i][j] += right[i][j + 1];
			}
		}

		int max = 0;
		// 统计
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
			  if (grid[i][j] == 'W' || grid[i][j] == 'E') continue; // 漏了这步,bug
				max = Math.max(max, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
			}
		}

		return max;
	}
}
