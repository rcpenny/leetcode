// Range Sum of BST 二叉搜索树的范围和

@EASY
public class LC938 {
	
	@BST
	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null) return 0;

		int sum = 0;
		if (L <= root.val && root.val <= R)
			sum += root.val;
		
		if (root.val > L)
			sum += rangeSumBST(root.left, L, R);

		if (root.val < R)
			sum += rangeSumBST(root.right, L, R);

		return sum;
	}
}
