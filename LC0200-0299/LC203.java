// Remove Linked List Elements 移除链表元素

@EASY
public class LC203 {

	@LinkedList
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		while (head.next != null) {
			if (head.next.val == val) head.next = head.next.next;
			else head = head.next;
		}

		return dummy.next;
	}
}
