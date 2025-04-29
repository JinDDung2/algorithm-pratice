package BOJ.길라잡이.backtracking;

import java.io.*;
import java.util.*;

public class P14889_스타트와링크 {
    // 1. 백트래킹으로 팀 조합 만들기
    // 2. 각 팀의 능력치 계산 -> 최솟값
    static class Problem {

        int N;
        int[][] data;
        boolean[] visited;
        int minDifference = Integer.MAX_VALUE;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            data = new int[N][N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            backtracking(0, 0);
            System.out.println(minDifference);
        }

        void backtracking(int start, int cnt) {
            if (cnt == N / 2) {
                calculateDifference();
                return;
            }

            for (int i = start; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    backtracking(i + 1, cnt + 1);
                    visited[i] = false;
                }
            }
        }

        void calculateDifference() {
            int teamA = 0;
            int teamB = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) teamA += data[i][j] + data[j][i];
                    else if (!visited[i] && !visited[j]) teamB += data[i][j] + data[j][i];
                }
            }

            int difference = Math.abs(teamA - teamB);
            minDifference = Math.min(minDifference, difference);
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
