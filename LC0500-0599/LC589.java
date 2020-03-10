// N-ary Tree Preorder Traversal N叉树的前序遍历

@EASY
public class LC589 {

	@Recursive
  public List<Integer> preorder(Node root) {
    List<Integer> result = new ArrayList<>();
    traverse(root, result);
    return result;
  }

  private void traverse(Node node, List<Integer> list) {
    if (node == null) return;

    list.add(node.val);
    for (Node child : node.children)
      traverse(child, list);
  }
}
