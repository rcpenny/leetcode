// Insert Interval 插入区间

@HARD
class LC57 {

  @Array
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<>();

		int insertIndex = 0;
 
		for (Interval in : intervals) {
			if (in.end < newInterval.start) {
				result.add(in);
				insertIndex++;
				continue;
			}

			if (in.start > newInterval.end) {
				result.add(in);
				continue;
			}

			newInterval.start = Math.min(newInterval.start, in.start);
			newInterval.end = Math.max(newInterval.end, in.end);
		}

		result.add(insertIndex, newInterval);

		return result;
  }
}
