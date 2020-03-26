// High Five 前五科的均分

@EASY
public class LC1086 {
  public int[][] highFive(int[][] items) {
    Map<Integer, Student> map = new TreeMap<>();

    for (int[] item : items) {
      if (!map.containsKey(item[0])) {
        map.put(item[0], new Student(item[0]));
      }
      map.get(item[0]).addScore(item[1]);
    }

    int[][] result = new int[map.size()][2];

    for (int id : map.keySet()) {
      result[id - 1][0] = id;
      result[id - 1][1] = map.get(id).averageScore();
    }

    return result;
  }
}

class Student {
  int id;
  PriorityQueue<Integer> scores;

  Student(int id) {
    this.id = id;
    this.scores = new PriorityQueue<>();
  }

  void addScore(int score) {
    if (scores.size() < 5) {
      scores.offer(score);
      return;
    }
    if (score > scores.peek()) {
      scores.offer(score);
      scores.poll();
    }
  }

  int averageScore() {
    int sum = 0;
    while (!scores.isEmpty()) sum += scores.poll();
    return sum / 5;
  }
}
