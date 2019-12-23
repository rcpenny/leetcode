// Serialize and Deserialize Binary Tree

@MEDIUM
@Microsoft
public class Codec {

  @BFS
  public String serialize(TreeNode root) {
    if (root == null) return "{}";

    StringBuilder sb = new StringBuilder();
    sb.append("{");

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        sb.append(String.valueOf(node.val));
        queue.offer(node.left);
        queue.offer(node.right);
      } else {
        sb.append("#");
      }
      sb.append(",");
    }

    int i = sb.length() - 1;
		while (sb.charAt(i) == '#' || sb.charAt(i) == ',') {
      sb.deleteCharAt(i--);
    }
		sb.append("}");

    return sb.toString();
  }

  
  public TreeNode deserialize(String data) {
    if ("{}".equals(data)) return null;

    String[] s = data.substring(1, data.length() - 1).split(",");
    
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.valueOf(s[0]));
    queue.offer(root);

    boolean addLeft = true;
    for (int i = 1; i < s.length; i++) {
      String tmp = s[i];

      if (!tmp.equals("#")) {
        TreeNode node = new TreeNode(Integer.valueOf(s[i]));

        if (addLeft) queue.peek().left = node;
        else queue.peek().right = node;

        queue.offer(node);
      }

      if (!addLeft) queue.poll();
      addLeft = !addLeft;
    }

    return root;
  }
}