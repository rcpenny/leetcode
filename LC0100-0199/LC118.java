// Pascal's Triangle 杨辉三角

@EASY
public class LC118 {

	@Array
	public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows == 0) return result;

    result.add(Arrays.asList(1));

    for (int i = 2; i <= numRows; i++) {
			List<Integer> prevRow = result.get(i - 2);
      List<Integer> curRow = new ArrayList<>();
      curRow.add(1);

      for (int j = 1; j < i - 1; j++) {
        curRow.add(prevRow.get(j) + prevRow.get(j - 1));
      }

      curRow.add(1);
      result.add(curRow);
    }

    return result;
  }
}
