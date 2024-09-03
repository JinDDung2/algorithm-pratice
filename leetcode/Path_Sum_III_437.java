package leetcode;

public class Path_Sum_III_437 {

    int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return result;
    }

    private void dfs(TreeNode node, long sum) {
        if (node == null) return;
        if (node.val == sum) result++;
        dfs(node.left, sum - node.val);
        dfs(node.right, sum - node.val);
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
