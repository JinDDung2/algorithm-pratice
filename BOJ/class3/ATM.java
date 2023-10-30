package BOJ.class3;

import java.io.*;
import java.util.*;

// [S4] 11399. ATM
public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.sort(dp);
        int rst = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i] + dp[i - 1];
            rst += dp[i];
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(rst);
    }
}
