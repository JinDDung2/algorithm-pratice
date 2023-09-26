package leetcode;

import java.util.ArrayList;
import java.util.List;

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

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        fill(root, result, 0);
        return result;
    }

    private void fill(TreeNode node, List<Integer> result, int depth) {
        if (node == null)
            return;

        if (depth == result.size()) {
            result.add(node.val);
        }
        fill(node.right, result, depth + 1);
        fill(node.left, result, depth + 1);
    }
}
