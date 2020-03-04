// Daily Temperatures 每日温度

@MEDIUM
public class DailyTemperatures {
	
	@Stack
	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>(); // 栈中放置索引

		int n = temperatures.length;
		int[] result = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			// 1. 当前元素大于栈顶元素，更新至当前元素 <= 栈顶元素
			// 单调递减栈，栈顶的元素必须大于当前温度
			while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
				stack.pop();
			}

			// 2. 维护完后求距离
			// 维护之后的新栈顶（当前温度）与次栈顶的索引相减就是结果
			result[i] = stack.isEmpty() ? 0 : stack.peek() - i;

			stack.push(i);
		}

		return result;
	}
}
