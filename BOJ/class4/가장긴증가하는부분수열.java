package BOJ.class4;

import java.io.*;
import java.util.*;

// [S2] 11053. 가장 긴 증가하는 부분 수열
public class 가장긴증가하는부분수열 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // System.out.println(Arrays.toString(dp));

        int cnt = 0;

        for (int temp : dp) {
            cnt = Math.max(temp, cnt);
        }

        System.out.println(cnt);
        br.close();
    }
}
