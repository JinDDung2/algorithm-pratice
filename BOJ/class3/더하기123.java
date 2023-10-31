package BOJ.class3;

import java.io.*;

// [S3] 9095. 1, 2, 3 더하기
public class 더하기123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2; // 1 1
        dp[3] = 4; // 1 2 1
        dp[4] = 7; // 3 3 1
        dp[5] = 13; // 2 6 4 1

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
