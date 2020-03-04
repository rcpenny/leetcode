// Construct Binary Tree from Preorder and Inorder Traversal从前序与中序遍历序列构造二叉树

@MEDIUM
public class LC105 {
	
	@DivideConquer
	@BinaryTree
	public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) return null;

    int value = preorder[0];
    int i = 0;

    TreeNode root = new TreeNode(value);
    while (inorder[i] != value) i++;

    root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
    root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
    
    return root;
  }
}
