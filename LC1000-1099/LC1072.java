// Two City Scheduling 两地调度

@EASY
public class LC1072 {
	
	@Greedy
	public int twoCitySchedCost(int[][] costs) {
    int totalCost = 0;

		// 假设全飞去城市A
    for (int i = 0; i < costs.length; i++)
      totalCost += costs[i][0];
    
    Arrays.sort(costs, (a, b) -> {
      return (a[1] - a[0]) - (b[1] - b[0]);
    });

    for (int i = 0; i < costs.length / 2; i++)
      totalCost += (costs[i][1] - costs[i][0]);

    return totalCost;
  }
}
