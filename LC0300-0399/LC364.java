// Nested List Weight Sum II 加权嵌套序列和 II

@MEDIUM
final class LC364 {

	@Backtracking
  public int depthSumInverse(List<NestedInteger> nestedList) {
    if (nestedList == null || nestedList.size() == 0) return 0;
    
    int depth = getDepth(nestedList);

    return getSum(nestedList, depth);
  }

  private int getSum(List<NestedInteger> nestedList, int depth) {
    if (nestedList == null || nestedList.size() == 0) return 0;
    int sum = 0;

    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) sum += ni.getInteger() * depth;
      else sum += getSum(ni.getList(), depth - 1);
    }

    return sum;
  }
  
  private int getDepth(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0) return 0;
		int depth = 0;

    for (NestedInteger ni : nestedList) {
			if (!ni.isInteger()) depth = Math.max(depth, getDepth(ni.getList()));
		}

		return depth + 1;
  }
}
