// Pascal's Triangle II 杨辉三角 II

@EASY
public class LC119 {
	
	@Array
	public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>();
    int N = rowIndex;
    long pre = 1;

    result.add(1);
    for (int k = 1; k <= N; k++) {
			long cur = pre * (N - k + 1) / k;
			result.add((int) cur);
			pre = cur;
    }

    return result;
  }
}
