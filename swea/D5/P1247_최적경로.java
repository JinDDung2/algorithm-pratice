package swea.D5;

import java.io.*;
import java.util.*;

public class P1247_최적경로 {

    public static void main(String[] args) throws IOException {
        P1247_최적경로 p = new P1247_최적경로();
        p.solution();
    }

    int N;
    int[][] distances;
    boolean[] visited;
    int minCost;

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            distances = new int[N + 2][2];
            visited = new boolean[N + 2];
            minCost = Integer.MAX_VALUE;

            // 시작점, 고객, 도착점
            StringTokenizer inputDots = new StringTokenizer(br.readLine());
            distances[0][0] = Integer.parseInt(inputDots.nextToken());
            distances[0][1] = Integer.parseInt(inputDots.nextToken());

            distances[N + 1][0] = Integer.parseInt(inputDots.nextToken());;
            distances[N + 1][1] = Integer.parseInt(inputDots.nextToken());;

            // 고객 좌표
            for (int i = 1; i < N + 1; i++) {
                distances[i][0] = Integer.parseInt(inputDots.nextToken());
                distances[i][1] = Integer.parseInt(inputDots.nextToken());
            }

            // 백트래킹
            backtracking(0, 0, 0);

            System.out.printf("#%d %d\n", t, minCost);
        }

        br.close();
    }

    int getDistance(int s, int e) {
        return Math.abs(distances[s][0] - distances[e][0]) + Math.abs(distances[s][1] - distances[e][1]);
    }

    void backtracking(int curr, int cnt, int cost) {
        if (cost >= minCost) return;

        // 모든 고객을 방문한 경우, 집으로 돌아가는 비용 추가
        if (cnt == N) {
            cost += getDistance(curr, N + 1);
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i, cnt + 1, cost + getDistance(curr, i));
                visited[i] = false;
            }
        }
    }
}
