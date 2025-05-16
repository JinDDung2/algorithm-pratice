package BOJ.길라잡이.dp.knapsack;

import java.io.*;
import java.util.*;

public class P16493_최대페이지수 {

    static class Problem {

        int N, M;
        int[] days;
        int[] pages;
        int[][] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            days = new int[M];
            pages = new int[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                days[i] = Integer.parseInt(st.nextToken());
                pages[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[M][N + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            int answer = solve(0, N);

            bw.write(String.valueOf(answer));
            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int idx, int remainingDays) {
            if (idx == M) return 0;
            if (remainingDays <= 0) return 0;

            if (dp[idx][remainingDays] != -1) return dp[idx][remainingDays];

            // 선택하지 않고 넘어감
            int answer = solve(idx + 1, remainingDays);

            if (remainingDays - days[idx] >= 0) {
                answer = Math.max(answer, solve(idx + 1, remainingDays - days[idx]) + pages[idx]);
            }

            return dp[idx][remainingDays] = answer;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
