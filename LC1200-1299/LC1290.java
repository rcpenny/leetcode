// Convert Binary Number in a Linked List to Integer 二进制链表转整数

@EASY
public class LC1290 {

	@BitManipulation
	public int getDecimalValue(ListNode head) {
    int sum = 0;

    while (head != null) {
			sum = (sum << 1) + head.val; 
      head = head.next;
    }

    return sum;
  }
}
