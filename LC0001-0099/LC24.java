// Swap Nodes in Pairs 两两交换链表中的节点

@MEDIUM
public class LC24 {

	@LinkedList
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode first = head;
		ListNode second = head.next;

		ListNode restNodes = swapPairs(second.next);

		first.next = restNodes;
		second.next = first;

		return second;
  }
}
