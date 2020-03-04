// Distribute Candies to People 分糖果 II

@EASY
public class LC1103 {

	@Math
  public int[] distributeCandies(int candies, int num_people) {
    int[] result = new int[num_people];

    int index = 0;
    int curCanday = 1;

    while (candies > 0) {
      if (candies < curCanday) {
        result[index % num_people] += candies;
        break;
      }

      result[(index++) % num_people] += curCanday;
      candies -= curCanday++;
    }

    return result;
  }
}
