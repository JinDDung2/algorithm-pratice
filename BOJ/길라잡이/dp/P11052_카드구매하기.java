package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P11052_카드구매하기 {

    static class Problem {

        int N;
        int[] prices;
        int[] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            prices = new int[N + 1];
            dp = new int[N + 1];
            Arrays.fill(dp, -1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            int result = solve(N);
            System.out.println(result);
        }

        int solve(int n) {
            if (n == 0) return 0;
            if (dp[n] != -1) return dp[n];

            int maxValue = 0;
            for (int i = 1; i <= n; i++) {
                maxValue = Math.max(maxValue, prices[i] + solve(n - i));
            }

            return dp[n] = maxValue;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
