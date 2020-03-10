// N-ary Tree Postorder Traversal N叉树的后序遍历

@EASY
public class LC589 {

	@Recursive
  public List<Integer> postorder(Node root) {
    List<Integer> result = new ArrayList<>();
    traverse(root, result);
    return result;
  }

  private void traverse(Node node, List<Integer> list) {
    if (node == null) return;

    for (Node child : node.children)
      traverse(child, list);
		
		list.add(node.val);
  }
}
