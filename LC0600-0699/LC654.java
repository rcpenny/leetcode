// Maximum Binary Tree 最大二叉树

@MEDIUM
publi class LC654 {

	@BottomUp
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums.length == 0) return null;

    int index = 0;

    for (int i = 1; i < nums.length; i++)
      if (nums[i] > nums[index]) index = i;

    TreeNode leftNode = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
    TreeNode rightNode = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));

    TreeNode root = new TreeNode(nums[index]);
    root.left = leftNode;
    root.right = rightNode;

    return root;
  }
}
