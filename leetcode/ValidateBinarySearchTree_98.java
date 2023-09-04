package leetcode;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;

        if (root.val >= maxVal || root.val <= minVal)
            return false;

        return isValid(root.left, minVal, root.val) && isValid(root.right, root.val, maxVal);
    }
}
