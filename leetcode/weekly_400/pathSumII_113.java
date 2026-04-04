package leetcode.weekly_400;

import java.util.ArrayList;
import java.util.List;

// 113. Path Sum II
public class pathSumII_113 {
    // 이진트리레어 root to leaf 경로 중 경로 합이 targetSum이랑 같은 모든 경로 list 반환
    // 경로 상태를 유지하며 dfs = 백트래킹
    // dfs 메서드 상태: 현재 노드, 현재까지 경로, 현재까지 합
    // 종료조건 = node.left와 node.right 모듀 null
    // 위 조건에서 targetSum 같으면 list에 넣기
    List<List<Integer>> result = new ArrayList<>();
    int target = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;

        dfs(root, new ArrayList<>(), 0);

        return result;
    }

    void dfs(TreeNode node, List<Integer> path, int sum) {
        if (node == null) return;

        path.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
        }

        dfs(node.left, path, sum);
        dfs(node.right, path, sum);
        path.remove(path.size() - 1);
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
