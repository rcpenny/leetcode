// LRU Cache

@MEDIUM
@Microsoft
public class LC146 {}

class Node {
  int key;
  int val;
  Node next;

  Node(int key, int val) {
    this.key = key;
    this.val = val;
  }
}

@DesignProblem
class LRUCache {
  int size;
  int capacity;

  Node dummy;
  Node tail;

  Map<Integer, Node> k2p; // represents keyToPrev

  public LRUCache(int capacity) {
    size = 0;
    this.capacity = capacity;

    dummy = new Node(0, 0);
    tail = dummy;

    k2p = new HashMap<>();
  }
  
  public int get(int key) {
    if (!k2p.containsKey(key)) return -1;
    moveToTail(key);
    return tail.val;
  }
  
  public void put(int key, int value) {
    if (get(key) != -1) {
      moveToTail(key);
      tail.val = value;
      return;
    }

    if (size < capacity) {
      Node node = new Node(key, value);
      tail.next = node;
      k2p.put(node.key, tail);
      tail = tail.next;
      size++;
      return;
    }

    Node head = dummy.next;
    k2p.remove(head.key);

    head.key = key;
    head.val = value;

    k2p.put(key, dummy);
    
    moveToTail(key);
  }

  private void moveToTail(int key) {
    if (!k2p.containsKey(key)) return;

    Node prev = k2p.get(key);
    Node current = prev.next;

    if (current == tail) return;

    if (current.next != null) k2p.put(current.next.key, prev);
    prev.next = current.next;

    tail.next = current;
    k2p.put(current.key, tail);

    tail = tail.next;
  }
}