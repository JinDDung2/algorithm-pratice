package leetcode;

import java.util.*;

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

public class Path_Sum_II_113 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return result;
        dfs(root, targetSum, new Stack<>());

        return result;
    }

    private void dfs(TreeNode root, int sum, Stack<Integer> stack) {
        stack.push(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(new ArrayList<Integer>(stack));
            };
        }
        if (root.left != null) {
            dfs(root.left, sum - root.val, stack);
        }
        if (root.right != null) {
            dfs(root.right, sum - root.val, stack);
        }
        stack.pop();
    }
}
