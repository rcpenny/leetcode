// Reverse Linked List 反转链表

@EASY
public class LC206 {
  
  @LinkedList
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;

      prev = curr;
      curr = next;
    }

    return prev; 
  }

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
 
    ListNode node = reverseList(head.next);

    head.next.next = head;
    head.next = null;

    return node;
  }
}
