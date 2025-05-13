package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P2631_줄세우기 {

    static class Problem {

        int N;
        int[] seq;
        int[] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            seq = new int[N];
            dp = new int[N];
            for (int i = 0; i < N; i++) {
                seq[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < N; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if(seq[i] > seq[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int noMovePeople = 0;
            for (int num : dp) {
                noMovePeople = Math.max(noMovePeople, num);
            }

            bw.write(String.valueOf(N - noMovePeople));
            bw.flush();
            bw.close();
            br.close();
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
