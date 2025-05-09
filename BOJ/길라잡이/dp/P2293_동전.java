package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P2293_동전 {

    static class Problem {

        int N, K;
        int[] coins;
        int[] dp;
        int[][] memo;

        void solutionWithBottomUp() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            dp = new int[K + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int i = coin; i <= K; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            System.out.println(dp[K]);
        }

        void solutionWithTopDown() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            memo = new int[N + 1][K + 1];
            for (int[] m : memo) {
                Arrays.fill(m, -1);
            }

            int result = solve(0, 0);
            System.out.println(result);
        }

        int solve(int idx, int sum) {
            if (sum == K) return 1;
            if (idx >= N || sum > K) return 0;

            if (memo[idx][sum] != -1) return memo[idx][sum];

            int skip = solve(idx + 1, sum);
            int use = solve(idx, sum + coins[idx]);

            return memo[idx][sum] = use + skip;
        }
    }


    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
//        problem.solutionWithBottomUp();
        System.out.println("------");
        problem.solutionWithTopDown();
    }
}
