package BOJ.class4;

import java.io.*;
import java.util.*;

// # [S1] RGB 거리
public class RGB거리 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken()); // 레드
            dp[i][1] = Integer.parseInt(st.nextToken()); // 그린
            dp[i][2] = Integer.parseInt(st.nextToken()); // 블루
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = dp[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = dp[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));

    }
}
