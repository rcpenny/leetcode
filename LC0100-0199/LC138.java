// Copy List with Random Pointer 复制带随机指针的链表

@MEDIUM
@HighFreq
public class LC138 {

  @HashTable
  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();

    Node ref = head;

    while (head != null) {
      map.put(head, new Node(head.val, null, null));
      head = head.next;
    }

    for (Node node : map.keySet()) {
      Node copy = map.get(node);
      copy.next = map.get(node.next);
      copy.random = map.get(node.random);
    }

    return map.get(ref);
  }
}
