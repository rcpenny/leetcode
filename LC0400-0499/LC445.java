// Add Two Numbers II 两数相加 II

@MEDIUM
class LC445 {

  @LinkedList
  @Stack
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    while (l1 != null) {
      s1.push(l1.val);
      l1 = l1.next;
    }

    while (l2 != null) {
      s2.push(l2.val);
      l2 = l2.next;
    }

    ListNode head = new ListNode(0);
    int carry = 0;

    while (!s1.isEmpty() || !s2.isEmpty()) {
      int sum = carry;
      
      sum += s1.isEmpty() ? 0 : s1.pop();
      sum += s2.isEmpty() ? 0 : s2.pop();

      carry = sum / 10;
      
      ListNode follow = new ListNode(sum % 10);
      follow.next = head.next;
      head.next = follow;
    }

    if (carry == 1) {
      ListNode follow = new ListNode(1);
      follow.next = head.next;
      head.next = follow;
    }

    return head.next;
  }
}
