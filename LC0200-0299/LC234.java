// Palindrome Linked List 回文链表

@EASY
class LC234 {

	@LinkedList
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    
    ListNode slow = dummy;
    ListNode fast = dummy;

    // 1. find middle of linked list
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // 2. split to two linked lists
    fast = slow.next;
    slow.next = null;
    slow = dummy.next;

    // 3. reverse second linked list
    ListNode prev = null;

    while (fast != null) {
      ListNode next = fast.next;
      fast.next = prev;
      prev = fast;
      fast = next;
    }

    // 4. compare 2 linked lists
    while (prev != null) {
      if (slow.val != prev.val) return false;
      slow = slow.next;
      prev = prev.next;
    }
    
    return true;
  }
}
