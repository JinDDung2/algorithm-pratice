package BOJ.길라잡이.dp.knapsack;

import java.io.*;
import java.util.*;

public class P12865_평범한배낭 {

    static class Problem {

        int N, K;
        int[] weights;
        int[] values;
        int[][] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            weights = new int[N];
            values = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                weights[i] = Integer.parseInt(st.nextToken());
                values[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[N][K + 1];
            for (int[] row : dp) {
                Arrays.fill(row, - 1);
            }

            int answer = solve(0, 0);

            bw.write(String.valueOf(answer));
            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int i, int w) {
            if (i == N) return 0;
            if (w > K) return 0;

            if (dp[i][w] != -1) return dp[i][w];

            // 해당 물품을 선택하지 않고 넘어감
            int answer = solve(i + 1, w);

            if (w + weights[i] <= K) {
                answer = Math.max(answer, solve(i + 1, w + weights[i]) + values[i]);
            }

            return dp[i][w] = answer;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
