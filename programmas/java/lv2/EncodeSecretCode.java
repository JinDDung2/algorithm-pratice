package programmas.java.lv2;

// 2025 프로그래머스 코드챌린지 1차 예선 비밀 코드 해독
public class EncodeSecretCode {

    int n;
    int[][] q;
    int[] ans;

    int answer = 0;
    int[] pick = new int[5];

    public int solution(int n, int[][] q, int[] ans) {
        // 중복없음 + 오름차순 -> 조합
        // nC5 -> 각 조합마다 q 순회 -> 백트래킹
        // 각 케이스 -> 검증
        // 142,506(30C5) * 10 * 25 =~ 3,500,000 -> 브르투포스
        this.n = n;
        this.q = q;
        this.ans = ans;

        dfs(1, 0);

        return answer;
    }

    void dfs(int start, int depth) {
        if (depth == 5) {
            if (isValid()) answer++;
            return;
        }

        for (int i = start; i <= n; i++) {
            pick[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    boolean isValid() {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;

            for (int a = 0; a < 5; a++) {
                for (int b = 0; b < 5; b++) {
                    if (pick[a] == q[i][b]) {
                        cnt++;
                        break;
                    }
                }
            }

            if (cnt != ans[i]) return false;
        }

        return true;
    }

}
