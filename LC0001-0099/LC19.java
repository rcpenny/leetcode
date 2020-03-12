// Remove Nth Node From End of List 删除链表的倒数第N个节点

@MEDIUM
public class LC19 {

	@LinkedList
	@TwoPointers
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode fast = dummy;
		ListNode slow = dummy;

		for (int i = 0; i <= n; i++) {
			fast = fast.next;
			if (fast == null) return head.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return dummy.next;
	}
}
