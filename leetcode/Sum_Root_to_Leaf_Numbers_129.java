/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Sum_Root_to_Leaf_Numbers_129 {
  // root.left == null && root.right == null 까지 탐색
  // 기존값 * 10 + 추가할 값
    int result = 0;
    public int sumNumbers(TreeNode root) {
        find(root, 0);

        return result;
    }

    private void find(TreeNode node, int curr) {
        if (node == null) return;
        curr = 10 * curr + node.val;
        if (node.left == null && node.right == null) {
            result += curr;
            return;
        }
        find(node.left, curr);
        find(node.right, curr);
    }
}
