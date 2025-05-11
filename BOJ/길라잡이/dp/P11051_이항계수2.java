package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P11051_이항계수2 {

    static class Problem {

        int N, K;
        int[][] dp;
        final int MOD = 10_007;

        void solutionWithBottomUp() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            dp = new int[N + 1][K + 1];
            for (int i = 1; i <= N; i++) {
                dp[i][1] = dp[i][K] = 1;
            }

            if (K == 0) {
                System.out.println(1);
                return;
            }

            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= Math.min(i, K); j++) {
                    if (j == 0 || j == i) {
                        dp[i][j] = 1;
                        continue;
                    }

                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;

                }
            }

            bw.write(String.valueOf(dp[N][K]));
            bw.flush();
            bw.close();
            br.close();
        }

        void solutionWithTopDown() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            if (K == 0) {
                System.out.println(1);
                return;
            }

            dp = new int[N + 1][K + 1];
            for (int[] d : dp) {
                Arrays.fill(d, -1);
            }

            int result = solve(N, K);

            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int n, int k) {
            if (k == 0 || k == n) return 1;
            if (dp[n][k] != -1) return dp[n][k];

            return dp[n][k] = (solve(n - 1, k - 1) + solve(n - 1, k)) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
//        problem.solutionWithBottomUp();
        problem.solutionWithTopDown();
    }
}
