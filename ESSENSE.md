# Tree
### 分治法解决问题的思路 (top down, bottom up)
- 先让左右子树去解决同样的问题，得到结果之后，然后再整合为父亲树的结果
- (top down 前序， bottom up 后序)
### 遍历法解决问题的思路
- 通过前序/中序/后序的某种遍历，游走整棵树，通过一个全局变量或者传递的参数来记录需要计算的结果
### BST 基本性质
1. left subtree < root <= right subtree
3. in-order traversal 是“non-decreasing”序列
