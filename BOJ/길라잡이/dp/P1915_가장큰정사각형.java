package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P1915_가장큰정사각형 {

    static class Problem {

        int N, M;
        int[][] board;
        int[][] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            dp = new int[N + 1][M + 1];
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = input.charAt(j) - '0';
                }
            }

            int result = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (board[i - 1][j - 1] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1],
                                   Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }

            bw.write(String.valueOf(result * result));
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
