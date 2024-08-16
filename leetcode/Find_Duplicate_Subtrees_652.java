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

// 652. Find Duplicate Subtrees
public class Find_Duplicate_Subtrees_652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        dfs(root, new HashMap<>(), result);

        return result;
    }

    private String dfs(TreeNode curr, Map<String, Integer> map, List<TreeNode> result) {
        if (curr == null) return " ";
        String str = curr.val + "," + dfs(curr.left, map, result) + "," + dfs(curr.right, map, result);
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2) result.add(curr);

        return str;
    }
}
