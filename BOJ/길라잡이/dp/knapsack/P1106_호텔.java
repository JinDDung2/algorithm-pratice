package BOJ.길라잡이.dp.knapsack;

import java.io.*;
import java.util.*;

public class P1106_호텔 {

    static class Problem {

        int C, N;
        int[] costs;
        int[] customers;
        int[] dp;
        final int INF = Integer.MAX_VALUE;
        final int MAX_CUSTOMER = 1000 + 100;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            costs = new int[N];
            customers = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                costs[i] = Integer.parseInt(st.nextToken());
                customers[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[MAX_CUSTOMER + 1];
            Arrays.fill(dp, INF);
            dp[0] = 0;

            for (int i = 0; i < N; i++) {
                int cost = costs[i];
                int customer = customers[i];

                for (int j = customer; j <= MAX_CUSTOMER; j++) {
                    if (dp[j - customer] != INF) {
                        dp[j] = Math.min(dp[j], dp[j - customer] + cost);
                    }
                }
            }

            int minCost = INF;
            for (int i = C; i <= MAX_CUSTOMER; i++) {
                if (dp[i] != -1) {
                    minCost = Math.min(minCost, dp[i]);
                }
            }

            bw.write(String.valueOf(minCost));
            bw.flush();
            bw.close();
            br.close();
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
