package leetcode;

public class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                result = 1;
            }
        }

        for (int j = 0; j < dp[0].length; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                result = 1;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        // for (int[] d : dp) {
        // System.out.println(Arrays.toString(d));
        // }

        return result * result;
    }
}
