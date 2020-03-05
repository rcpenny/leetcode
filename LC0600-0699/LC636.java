// Exclusive Time of Functions 函数的独占时间

@MEDIUM
public class LC636 {

	@Stack
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] result = new int[n];

		if (logs == null || logs.size() == 0) {
			return result;
		}

		Stack<Integer> stack = new Stack<>();
		
		int lastTimestamp = 0;

		for (String log : logs) {
			String[] segments = log.split(":");

			int id = Integer.parseInt(segments[0]);
			String status = segments[1];
			int timestamp = Integer.parseInt(segments[2]);
			
			if (!stack.isEmpty()) {
				result[stack.peek()] += (timestamp - lastTimestamp);
			}
			
			if ("start".equals(status)) {
				stack.push(id);
			} else {
				timestamp++;
				result[stack.peek()]++;
				stack.pop();
			}
			
			lastTimestamp = timestamp;
		}
		
		return result;
	}
}
