package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P9252_LCS2 {

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
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            StringBuilder sb = new StringBuilder();
            int i = n, j = m;

            while (i > 0 && j > 0) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    sb.append(str1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

            bw.write(dp[n][m] + "\n");
            if (dp[n][m] > 0) bw.write(sb.reverse().toString());
            bw.flush();
            bw.close();
            br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solutionWithBottomUp();
    }
}
