package leetcode;

public class Count_Good_Nodes_in_Binary_Tree_1448 {

    int result = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);

        return result;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) return;
        if (node.val >= target) {
            result++;
            target = node.val;
        }

        dfs(node.left, target);
        dfs(node.right, target);
    }

}

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
