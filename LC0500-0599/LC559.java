// Maximum Depth of N-ary Tree N叉树的最大深度

@EASY
public class LC559 {

  @BottomUp
  public int maxDepth(Node root) {
    if (root == null) return 0;

    int max = 0;
	
    for (Node child : root.children)
      max = Math.max(max, maxDepth(child));

    return max + 1;
  }
}
