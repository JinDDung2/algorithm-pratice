package BOJ.길라잡이.dp.knapsack;

import java.io.*;
import java.util.*;

public class P2629_양팔저울 {

    static class Problem {

        int N, M;
        int[] weights;
        int[] targets;
        boolean[][] dp; // dp[i][j]: i번째 추까지 사용해서 j무게까지 가능한가?

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            weights = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxWeights = 0;
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
                maxWeights += weights[i];
            }

            M = Integer.parseInt(br.readLine());
            targets = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                targets[i] = Integer.parseInt(st.nextToken());
            }

            int offset = maxWeights;
            dp = new boolean[N + 1][2 * maxWeights + 1];

            dp[0][offset] = true;
            for (int i = 1; i <= N; i++) {
                int currWeight = weights[i - 1];
                for (int j = 0; j <= 2 * maxWeights; j++) {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true; // 현재 추 사용하지 않는 경우
                        int nextIdxAdd = j + currWeight;
                        if (nextIdxAdd <= 2 * maxWeights) { // 더한 추들과 비교하는 경우
                            dp[i][nextIdxAdd] = true;
                        }

                        int nextIdxSub = j - currWeight;
                        if (nextIdxSub >= 0) { // 뺀 추들과 비교하는 경우
                            dp[i][nextIdxSub] = true;
                        }
                    }
                }
            }

            for (int target : targets) {
                if (target <= maxWeights && dp[N][target + offset]) {
                    bw.write("Y ");
                } else {
                    bw.write("N ");
                }
            }



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
