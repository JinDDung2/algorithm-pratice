package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P11066_파일합치기 {

    static class Problem {

        int T, K;
        int[] files;
        int[] prefixSum;
        int[][] dp;

        void solutionWithBottomUp() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            T = Integer.parseInt(br.readLine());

            while (T-- > 0) {
                K = Integer.parseInt(br.readLine());
                files = new int[K + 1];
                prefixSum = new int[K + 1];
                dp = new int[K + 1][K + 1];

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= K; i++) {
                    files[i] = Integer.parseInt(st.nextToken());
                    prefixSum[i] = prefixSum[i - 1] + files[i];
                }

                for (int len = 2; len <= K; len++) { // 구간 길이
                    for (int i = 1; i <= K - len + 1; i++) {
                        int j = i + len - 1;
                        dp[i][j] = Integer.MAX_VALUE;

                        for (int k = i; k < j; k++) { // 병합 나누는 지점
                            // i~k 합친 비용 + k+1~j 합친 비용 + 전체 구간 파일 크기(누적합 활용)
                            int cost = dp[i][k] + dp[k + 1][j] + prefixSum[j] - prefixSum[i - 1];
                            dp[i][j] = Math.min(dp[i][j], cost);
                        }
                    }
                }

                bw.write(dp[1][K] + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        }

        void solutionWithTopDown() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            T = Integer.parseInt(br.readLine());

            while (T-- > 0) {
                K = Integer.parseInt(br.readLine());
                files = new int[K + 1];
                prefixSum = new int[K + 1];
                dp = new int[K + 1][K + 1];

                for (int[] r : dp) {
                    Arrays.fill(r, -1);
                }

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= K; i++) {
                    files[i] = Integer.parseInt(st.nextToken());
                    prefixSum[i] = prefixSum[i - 1] + files[i];
                }

                int result = solve(1, K);
                bw.write(result + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int i, int j) {
            if (i == j) return 0;
            if (dp[i][j] != -1) return dp[i][j];

            dp[i][j] = Integer.MAX_VALUE;

            for (int k = i; k < j; k++) {
                int cost = solve(i, k) + solve(k + 1, j) + prefixSum[j] - prefixSum[i - 1];
                dp[i][j] = Math.min(dp[i][j], cost);
            }

            return dp[i][j];
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
//        problem.solutionWithBottomUp();
        problem.solutionWithTopDown();
    }
}
