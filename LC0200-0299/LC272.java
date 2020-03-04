// Closest Binary Search Tree Value II 最接近的二叉搜索树值 II

@HARD
public class LC272 {
	
	@Stack
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> result = new ArrayList<>();
		if (root == null || k == 0) return result;

		Stack<TreeNode> next = new Stack<>();
		Stack<TreeNode> prev = new Stack<>();

		while (root != null) {
			if (root.val < target) {
				prev.push(root);
				root = root.right;
			} else {
				next.push(root);
				root = root.left;
			}
		}

		while (result.size() < k) {
			double diff_p = prev.isEmpty() ? Double.MAX_VALUE :  target - prev.peek().val;
			double diff_n = next.isEmpty() ? Double.MAX_VALUE : next.peek().val - target;

			if (diff_p < diff_n) {
				result.add(prev.peek().val);
				movePrev(prev);
			} else {
				result.add(next.peek().val);
				moveNext(next);
			}
		}

		return result;
	}

	private void movePrev(Stack<TreeNode> prev) {
		TreeNode tmp = prev.pop().left;
		while (tmp != null) {
			prev.push(tmp);
			tmp = tmp.right;
		}
	}

	private void moveNext(Stack<TreeNode> next) {
		TreeNode tmp = next.pop().right;
		while (tmp != null) {
			next.push(tmp);
			tmp = tmp.left;
		}
	}
}
