package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P2156_포도주시식 {

    static class Problem {

        int N;
        int[] data;
        int[] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            data = new int[N];
            dp = new int[N];
            Arrays.fill(dp, -1);
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(br.readLine());
            }

            if (N == 1) {
                System.out.println(data[0]);
                return;
            } else if (N == 2) {
                System.out.println(data[0] + data[1]);
                return;
            }

            dp[0] = data[0];
            dp[1] = data[0] + data[1];
            dp[2] = Math.max(dp[1], Math.max(data[0] + data[2], data[1] + data[2]));

            for (int i = 3; i < N; i++) {
                dp[i] = Math.max(dp[i - 1],
                        Math.max(dp[i - 2] + data[i], dp[i - 3] + data[i - 1] + data[i])
                );
            }
            System.out.println(dp[N - 1]);
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
