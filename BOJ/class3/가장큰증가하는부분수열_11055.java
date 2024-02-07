package BOJ.class3;

import java.io.*;
import java.util.*;

// [S2] 11055. 가장 큰 증가하는 부분 수열
public class 가장큰증가하는부분수열_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }

        System.out.println(result);
    }
}
