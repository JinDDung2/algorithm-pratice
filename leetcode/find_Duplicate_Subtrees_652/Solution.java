package leetcode.find_Duplicate_Subtrees_652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    List<TreeNode> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);

        return result;
    }

    String dfs(TreeNode node) {
        if (node == null) return "#";

        String left = dfs(node.left);
        String right = dfs(node.right);

        String serial = node.val + "," + left + "," + right;
        int count = map.getOrDefault(serial, 0);

        if (count == 1) {
            result.add(node);
        }

        map.put(serial, count + 1);

        return serial;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
