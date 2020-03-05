// Lemonade Change 柠檬水找零

@EASY
class LC860 {

  @Greedy
  public boolean lemonadeChange(int[] bills) {
    int five = 0;
    int ten = 0;
    int twenty = 0;

    for (int i = 0; i < bills.length; i++) {
      int money = bills[i];

      if (money == 5) {
        five++;
      } else if (money == 10) {
        if (five == 0) return false;
        five--;
        ten++;
      } else if (money == 20) {
        if (ten == 0) {
          if (five < 3) return false;
          five -= 3;
        } else {
          if (five == 0) return false;
          five--;
          ten--;
        }
      }
    }

    return true;
  }
}
