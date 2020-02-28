// Meeting Rooms 会议室

@EASY
public class LC252 {

	// O(nLogn) O(1)
  @Sorting
  public boolean canAttendMeetings(List<Interval> intervals) {
    if (intervals == null || intervals.size() <= 1) return true;

		Collections.sort(intervals, (a, b) -> {
			return a.start != b.start ? a.start - b.start : a.end - b.end;
		});

    for (int i = 0; i < intervals.size() - 1; i++)
      if (intervals.get(i).end > intervals.get(i + 1).start)
				return false;

    return true;
	}

	// O(n) O(n)
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
