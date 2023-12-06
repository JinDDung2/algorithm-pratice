package leetcode;

import java.util.Arrays;

// 62. Unique Paths
public class UniquePaths {
    public int uniquePathsV2(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 1);

        for (int i = 1; i < m; i++) {
            int[] next = new int[n];
            for (int j = 0; j < n; j++) {
                next[j] = j == 0 ? 1 : next[j - 1] + prev[i];
            }
            prev = next;
        }
        return prev[n - 1];
    }

    public int uniquePathsV1(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
