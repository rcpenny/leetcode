// Average of Levels in Binary Tree 二叉树的层平均值

@EASY
public class LC637 {

	@BFS
	public List<Double> averageOfLevels(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		List<Double> results = new ArrayList<>();

		while (!queue.isEmpty()) {
			int size = queue.size();
			long sum = 0;

			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				sum = sum + tmp.val;
				if (tmp.left != null) queue.offer(tmp.left);
				if (tmp.right != null) queue.offer(tmp.right);
			}
			
			Double avg = sum * 1.0 / size;
			results.add(avg);
		}

		return results;
	}
