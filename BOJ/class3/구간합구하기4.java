package BOJ.class3;

import java.io.*;
import java.util.*;

// [S3] 11659. 구간 합 구하기4
public class 구간합구하기4 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i - 1] + dp[i - 1];
        }

        // System.out.println(Arrays.toString(dp));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(dp[e] - dp[s - 1]);
        }
    }
}