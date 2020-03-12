// Delete Node in a Linked List 删除链表中的节点

@EASY
public class LC237 {

	@LinkedList
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
