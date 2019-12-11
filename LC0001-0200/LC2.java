// Add Two Numbers

@MEDIUM
class LC2 {
	
	@LinkedList
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		int carry = 0;

		while (l1 != null || l2 != null) {
			int sum = 0;

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			ListNode node = new ListNode((sum + carry) % 10);
			tail.next = node;
			tail = node;

			carry = (sum + carry) / 10;
		}


		tail.next = carry != 0 ? new ListNode(1) : null;
		
		return dummy.next;
	}
}
