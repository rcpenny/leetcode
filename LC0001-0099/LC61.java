// Rotate List 旋转链表

@MEDIUM
public class RotateList {
  public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) return head;
		
		int len = 1; 
    ListNode last = head;
		
		// 1. 找到最后一个node和list长度
		while (last.next != null) {
      len++;
      last = last.next;
    }

		// 重要！
    k = k % len;
    if (k == 0) return head;
		
    last.next = head;
		
		// 2. 找到切断点，切断
    // move foward and disconnect at position ???
    ListNode disconnect = head;
    for (int i = 0; i < len - k - 1; i++) {
      disconnect = disconnect.next;
    }

    head = disconnect.next;
		disconnect.next = null;

    return head;
  }
}
