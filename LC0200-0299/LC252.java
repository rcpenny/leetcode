// Meeting Rooms 会议室

@EASY
public class LC252 {

  @Heap
  public boolean canAttendMeetings(List<Interval> intervals) {
    if (intervals == null || intervals.size() <= 1) return true;

		Collections.sort(intervals, (a, b) -> {
			if (a.start != b.start) return a.start - b.start;
			return a.end - b.end;
		});

    for (int i = 0; i < intervals.size() - 1; i++) {
      Interval current = intervals.get(i);
      Interval next = intervals.get(i + 1);
      if (current.end > next.start) return false;
    }

    return true;
	}
	
  @SweepLine
	public boolean canAttendMeetings2(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) return true;

		int end = 0;
		for (Interval i : intervals)
			end = Math.max(end, i.end);

		int[] meetings = new int[end + 1];

		for (Interval i : intervals) {
			meetings[i.start]++;
			meetings[i.end]--;
		}

		int overlap = 0;
		for (int t : meetings) {
			overlap += t;
			if (overlap > 1) return false;
		}

		return true;
	}
}