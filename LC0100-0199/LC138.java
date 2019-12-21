// Copy List with Random Pointer

@MEDIUM
@Microsoft
public class LC138 {

  @LinkedList
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
