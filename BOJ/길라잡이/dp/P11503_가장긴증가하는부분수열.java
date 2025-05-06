package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P11503_가장긴증가하는부분수열 {

    static class Problem {

        int N;
        int[] data;
        int[] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            data = new int[N];
            dp = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (data[i] > data[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int maxCount = 0;
            for (int num : dp) {
                maxCount = Math.max(maxCount, num);
            }

            System.out.println(maxCount);
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
