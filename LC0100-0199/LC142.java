// Linked List Cycle II 环形链表 II

@MEDIUM
public class LC142 {

	@TwoPointers
  public ListNode detectCycle(ListNode head) {
    if (head == null) return null;

    ListNode fast = head;
    ListNode slow = head;
		ListNode intersection = head;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
			slow = slow.next;

      if (fast == slow) {
				// 套圈，画图看, 可证明距离
        while (intersection != slow) {
          intersection = intersection.next;
          slow = slow.next;
        }
        return intersection;
      }
    }
    return null;
  }
}
