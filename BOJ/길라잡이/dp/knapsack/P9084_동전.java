package BOJ.길라잡이.dp.knapsack;

import java.io.*;
import java.util.*;

public class P9084_동전 {

    static class Problem {

        int T, N, M;
        int[] coins;
        int[][] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            T = Integer.parseInt(br.readLine());

            while (T-- > 0) {
                N = Integer.parseInt(br.readLine());
                coins = new int[N];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    coins[i] = Integer.parseInt(st.nextToken());
                }
                M = Integer.parseInt(br.readLine());
                dp = new int[N][M + 1];
                for (int[] row : dp) {
                    Arrays.fill(row, -1);
                }

                int answer = solve(0, 0);
                bw.write(answer + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int idx, int money) {
            if (idx == N || money > M) return 0;
            if (money == M) return 1;

            if (dp[idx][money] != -1) return dp[idx][money];

            // 현재 동전을 사용하지 않을 때
            int answer = solve(idx + 1, money);

            // 현재 동전 사용할 때(인덱스는 그대로)
            if (money + coins[idx] <= M) {
                answer += solve(idx, money + coins[idx]);
            }

            return dp[idx][money] = answer;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
