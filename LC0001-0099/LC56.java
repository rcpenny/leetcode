// Merge Intervals 合并区间

@MEDIUM
@HighFreq
public class LC56 {
  
  @Sort
  @Array
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return intervals;
    }
    
    Arrays.sort(intervals, (a, b) -> {
      if (a[0] != b[0]) return a[0] - b[0];
      return a[1] - b[1];
    });

    int start = intervals[0][0];
    int end = intervals[0][1];

    List<int[]> result = new ArrayList<>();

    for (int i = 1; i < intervals.length; i++) {
      int[] in = intervals[i];

      if (in[0] > end) {
        result.add(new int[] {start, end});
        start = in[0];
        end = in[1];
        continue;
      }

      end = Math.max(end, in[1]);
    }
    result.add(new int[] {start, end});

    int[][] merged = new int[result.size()][2];
    for (int i = 0; i < merged.length; i++)
      merged[i] = result.get(i);
    
    return merged;
  }
}
