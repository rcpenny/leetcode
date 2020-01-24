// Meeting Rooms II 会议室 II

@MEDIUM
public class LC253 {

  @SweepLine
  public int minMeetingRooms(int[][] intervals) {
    List<Stamp> list = new ArrayList<>();

    for (int[] in : intervals) {
      list.add(new Stamp(in[0], true));
      list.add(new Stamp(in[1], false));
    }

    Collections.sort(list, (a, b) -> {
      if (a.time != b.time) return a.time - b.time;
      return a.start ? 1 : -1;
    });

    int minRoom = 0;
    int roomCount = 0;

    for (Stamp stamp : list) {
      int offset = stamp.start ? 1 : -1;
      roomCount += offset;
      minRoom = Math.max(minRoom, roomCount);
    }

    return minRoom;
  }

  class Stamp {
    int time;
    boolean start;
    
    Stamp(int time, boolean start) {
      this.time = time;
      this.start = start;
    }
  }
}