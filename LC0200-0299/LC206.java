// Reverse Linked List

@EASY
@Microsoft
public class LC206 {
  
  @LinkedList
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
}