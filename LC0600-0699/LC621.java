// Task Scheduler 任务调度器

@MEDIUM
public class LC621 {

	@Greedy
	public int leastInterval(char[] tasks, int n) {
    int[] freqs = new int[26];
    for (int i = 0; i < tasks.length; i++)
      freqs[tasks[i] - 'A']++;

    Arrays.sort(freqs);

    // number of characters with max freqs
    int count = 1;
    for (int i = 24; i >= 0; i--) {
      if (freqs[i] != freqs[25]) break;
      count++;
    }
    
    // 这个比较想一想这个例子：AAABBBCCCDDD n = 2
    // 其实一旦无法fit in A _ _ A _ _ A _ _ 这个pattern,说明最长就是tasks length了. 还是hin tricky
    return Math.max(tasks.length, (freqs[25] - 1) * (n + 1) + count);
  }
}
