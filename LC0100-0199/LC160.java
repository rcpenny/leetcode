// Intersection of Two Linked Lists

@EASY
@Microsoft
public class LC160 {

  @LinkedList
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {      
    ListNode A = headA;
    ListNode B = headB;

    while (A != null || B != null) {
      if (A == B) return A;
      
      A = A == null ? headB : A.next;
      B = B == null ? headA : B.next;
    }

    return null;
  }
}
