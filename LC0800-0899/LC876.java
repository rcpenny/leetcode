// Middle of the Linked List 链表的中间结点

@EASY
public class LC876 {
  
  @LinkedList
  public ListNode middleNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }
}
