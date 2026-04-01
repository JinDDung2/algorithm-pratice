package leetcode;

// 129. Sum Root to Leaf Numbers
public class SumNumbers_129 {
    // 트리 탐색할 때마다 문자열합치기
    // leaf노드까지 탐색이 끝나면 합친 문자열을 숫자로 변환 후 더히기
    // 여기서 탐색이 끝나면 어디에 저장할까?
    // 아니면 null이 될 때 그 값을 더할까?
    // 문자열을 사용할필요가 있나? "이전숫자 * 10 + 현재숫자"
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode node, int curr) {
        // 노드 없다면 더할 값이 없음
        if (node == null) return 0;

        // 이전 숫자 * 10 + 현재 숫자
        int next = curr * 10 + node.val;

        // 리프 노드면 반환
        if(node.left == null && node.right == null) {
            return next;
        }

        // 왼쪽 + 오른쪽 합
        return dfs(node.left, next) + dfs(node.right, next);
    }
}
