// Reverse Linked List 反转链表

@EASY
public class LC206 {
  
  @LinkedList
  @Iterative
  public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    ListNode nex = null;

    while (cur != null) {
      nex = cur.next;
      cur.next = pre;

      pre = cur;
      cur = nex;
    }

    return pre; 
  }

  @Recursive
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode node = reverseList(head.next);

    // 这个解决上一个recursive call的 head.next = null
    head.next.next = head;

    head.next = null;

    return node;
  }
}