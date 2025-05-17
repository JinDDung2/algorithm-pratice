package BOJ.길라잡이.dp.knapsack;

import java.io.*;
import java.util.*;

public class P17845_수강과목 {

    static class Problem {

        int N, K;
        int[] times;
        int[] ranks;
        int[][] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            times = new int[K];
            ranks = new int[K];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                ranks[i] = Integer.parseInt(st.nextToken());
                times[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[K][N + 1];
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
            if (idx == K) return 0;
            if (time > N) return -1; // 방어적 코딩

            if (dp[idx][time] != -1) return dp[idx][time];

            // 현재 과목을 선택하지 않을 때
            int answer = solve(idx + 1, time);

            // 현재 과목을 선택할 때
            if (time + times[idx] <= N) {
                answer = Math.max(answer, solve(idx + 1, time + times[idx]) + ranks[idx]);
            }

            return dp[idx][time] = answer;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
