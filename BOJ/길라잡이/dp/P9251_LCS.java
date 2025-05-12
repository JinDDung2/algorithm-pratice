package BOJ.길라잡이.dp;

import java.io.*;
import java.util.Arrays;

public class P9251_LCS {

    static class Problem {

        String str1;
        String str2;
        int[][] dp;

        void solutionWithBottomUp() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            str1 = br.readLine();
            str2 = br.readLine();

            int n = str1.length();
            int m = str2.length();

            dp = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            bw.write(String.valueOf(dp[n][m]));
            bw.flush();
            bw.close();
            br.close();
        }

        void solutionWithTopDown() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            str1 = br.readLine();
            str2 = br.readLine();

            int n = str1.length();
            int m = str2.length();

            dp = new int[n + 1][m + 1];
            for (int[] d : dp) {
                Arrays.fill(d, -1);
            }

            int result = solve(n - 1, m - 1);

            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int i, int j) {
            if (i < 0 || j < 0) return 0;
            if (dp[i][j] != -1) return dp[i][j];

            if (str1.charAt(i) == str2.charAt(j)) {
                dp[i][j] = solve(i - 1, j - 1) + 1;
            } else {
                dp[i][j] = Math.max(solve(i - 1, j), solve(i, j - 1));
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
