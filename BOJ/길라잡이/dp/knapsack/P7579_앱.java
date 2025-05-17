package BOJ.길라잡이.dp.knapsack;

import java.io.*;
import java.util.*;

public class P7579_앱 {

    static class Problem {

        int N, M;
        int[] memories;
        int[] costs;
        int[][] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            memories = new int[N];
            costs = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                memories[i] = Integer.parseInt(st.nextToken());
            }

            int totalCostSum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
                totalCostSum += costs[i];
            }

            dp = new int[N + 1][totalCostSum + 1];
            int minCost = Integer.MAX_VALUE;

            for (int i = 1; i <= N; i++) {
                int memory = memories[i - 1];
                int cost = costs[i - 1];
                for (int j = 0; j <= totalCostSum; j++) {
                    if (j >= cost) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + memory);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }

                    if (dp[i][j] >= M) {
                        minCost = Math.min(minCost, j);
                    }
                }
            }

            bw.write(String.valueOf(minCost));
            bw.flush();
            bw.close();
            br.close();
        }

        void solutionWithTopDown() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            memories = new int[N];
            costs = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                memories[i] = Integer.parseInt(st.nextToken());
            }

            int totalCostSum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
                totalCostSum += costs[i];
            }

            dp = new int[N][totalCostSum + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            int answer = Integer.MAX_VALUE;
            for (int i = 0; i <= totalCostSum; i++) {
                if (solve(0, i) >= M) {
                    answer = i;
                    break;
                }
            }

            bw.write(String.valueOf(answer));
            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int idx, int currCost) {
            if (idx == N) return 0;

            if (dp[idx][currCost] != -1) return dp[idx][currCost];

            // 현재 앱을 선택하지 않을 때
            int answer = solve(idx + 1, currCost);

            // 현재 앱을 선택할 때
            if (currCost >= costs[idx]) {
                answer = Math.max(answer, solve(idx + 1, currCost - costs[idx]) + memories[idx]);
            }

            return dp[idx][currCost] = answer;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
//        problem.solution();
        problem.solutionWithTopDown();
    }
}
