package BOJ.class3;

import java.io.*;

// [S3] 11276. 2*n 타일링
public class 타일링2xn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        if (N <= 2) {
            System.out.println(N);
            return;
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[N]);
    }
}
