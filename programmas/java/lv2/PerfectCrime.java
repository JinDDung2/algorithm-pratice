package programmas.java.lv2;

import java.util.Arrays;

// 2025 프로그래머스 코드챌린지 2차 예선 - 완점 범죄
public class PerfectCrime {

    final int INF = 1_000_000_000;
    int[][] info;
    int[][] memo;
    int N, n, m;

    public int solution(int[][] info, int n, int m) {
        // 모든 물건을 방문해야하며
        // A < n, B < m을 만족하는
        // A의 가치 최소합

        this.info = info;
        this.n = n;
        this.m = m;
        this.N = info.length;
        memo = new int[N][m];

        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }

        int answer = solve(0, 0);
        return answer >= n ? -1 : answer;
    }

    int solve(int idx, int b) {
        if (b >= m) return INF; // B가 잡히는 경우
        if (idx == N) return 0; // 목표지점에 도달한 경우
        if (memo[idx][b] != -1) return memo[idx][b]; // 이미 계산됨

        int takeA = solve(idx + 1, b) + info[idx][0];
        int takeB = solve(idx + 1, b + info[idx][1]);
        int result = Math.min(takeA, takeB);

        return memo[idx][b] = result;
    }

}
