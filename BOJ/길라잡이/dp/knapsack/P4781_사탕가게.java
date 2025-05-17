package BOJ.길라잡이.dp.knapsack;

import java.io.*;
import java.util.*;

public class P4781_사탕가게 {

    static class Problem {

        int n;
        int m;
        int[] calories;
        int[] coins;
        int[][] memo;
        int[] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken().replace(".", ""));

                if (n == 0 && m == 0) break;

                calories = new int[n];
                coins = new int[n];
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    calories[i] = Integer.parseInt(st.nextToken());
                    coins[i] = Integer.parseInt(st.nextToken().replace(".", ""));
                }
                /* 재귀
                memo = new int[n][m + 1];
                for (int[] row : memo) {
                    Arrays.fill(row, -1);
                }

                int answer = solve(0, 0)
                ;*/
                dp = new int[m + 1];
                for (int i = 0; i < n; i++) {
                    int currCalorie = calories[i];
                    int currCoin = coins[i];

                    for (int j = currCoin; j <= m; j++) {
                        dp[j] = Math.max(dp[j], dp[j - currCoin] + currCalorie);
                    }
                }

                bw.write(dp[m] + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int idx, int coin) { // 메모리 초과
            if (idx == n) return 0;
            if (coin > m) return -1;

            if (memo[idx][coin] != -1) return memo[idx][coin];

            // 현재 사탕을 선택하지 않을 때
            int answer = solve(idx + 1, coin);

            // 현재 사탕을 선택할 때(인덱스 변화 없음)
            if (coin + coins[idx] <= m) {
                answer = Math.max(answer, solve(idx, coin + coins[idx]) + calories[idx]);
            }

            return memo[idx][coin] = answer;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
