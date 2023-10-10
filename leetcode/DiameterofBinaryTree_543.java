package leetcode;

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
public class DiameterofBinaryTree_543 {
    // root == null -> dia = 0
    // 왼쪽과 서브트리의 높이와 지름, 오른쪽 서브트리의 높이와 지름
    // 현재 노드를 거쳐 diameter 계산 -> Max(왼쪽 높이 + 오른쪽 높이 + 1, 왼쪽 최대거리, 오른쪽 최대거리)
    // 높이는 Max(왼쪽 높이, 오른쪽 높이) + 1

    class Info {
        int dia;
        int height;

        public Info(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }

    public Info getDia(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info l = getDia(root.left);
        Info r = getDia(root.right);

        int d = Math.max(l.height + r.height + 1, Math.max(l.dia, r.dia));
        int h = Math.max(l.height, r.height) + 1;
        return new Info(d, h);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Info result = getDia(root);
        return result.dia - 1;
    }
}
