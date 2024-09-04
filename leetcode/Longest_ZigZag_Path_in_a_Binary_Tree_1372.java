package leetcode;

public class Longest_ZigZag_Path_in_a_Binary_Tree_1372 {

    int result = 0;

    public int longestZigZag(TreeNode root) {
        // 방향에 대한 인지 필요
        // 지그재그 선의 개수 파악 필요
        dfs(root, true, 0); // true: left
        dfs(root, false, 0); // false: right

        return result;
    }

    private void dfs(TreeNode node, boolean isLeft, int cnt) {
        if (node == null) return;

        result = Math.max(result, cnt);

        if (isLeft) {
            dfs(node.left, false, cnt + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.right, true, cnt + 1);
            dfs(node.left, false, 1);
        }
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
