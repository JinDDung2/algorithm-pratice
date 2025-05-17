package BOJ.길라잡이.dp.knapsack;

import java.io.*;
import java.util.*;

public class P14728_벼락치기 {

    static class Problem {

        int N, T;
        int[] times;
        int[] scores;
        int[][] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            times = new int[N];
            scores = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                times[i] = Integer.parseInt(st.nextToken());
                scores[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[N][T + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            int answer = solve(0, 0);

            bw.write(String.valueOf(answer));
            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int idx, int time) {
            if (idx == N) return 0;
            if (time > T) return -1; // 방어적 코딩.

            if (dp[idx][time] != -1) return dp[idx][time];

            // 해당 문제를 선택하지 않을 때
            int answer = solve(idx + 1, time);

            // 해당 문제를 선택할 때
            if (time + times[idx] <= T) {
                answer = Math.max(answer, solve(idx + 1, time + times[idx]) + scores[idx]);
            }

            return dp[idx][time] = answer;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
