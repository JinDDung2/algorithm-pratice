package BOJ.길라잡이.parametric;

import java.io.*;
import java.util.*;

public class P1890_점프 {

    static class Problem {

        int N;
        int[][] board;
        long[][] dp;

        void solutionWithBottomUp() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            dp = new long[N][N];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = 1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int jump = board[i][j];
                    if (jump == 0 || dp[i][j] == 0) continue;

                    if (i + jump < N) {
                        dp[i + jump][j] += dp[i][j];
                    }

                    if (j + jump < N) {
                        dp[i][j + jump] += dp[i][j];
                    }
                }
            }

            bw.write(String.valueOf(dp[N - 1][N - 1]));
            bw.flush();
            bw.close();
            br.close();
        }

        void solutionWithTopDown() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            dp = new long[N][N];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = -1;
                }
            }

            long result = solve(0, 0);

            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            br.close();
        }

        long solve(int x, int y) {
            if (x == N - 1 && y == N - 1) return 1;
            if (x >= N || y >= N || board[x][y] == 0) return 0;

            if (dp[x][y] != -1) return dp[x][y];

            dp[x][y] = 0;
            int jump = board[x][y];

            dp[x][y] += solve(x + jump, y);
            dp[x][y] += solve(x, y + jump);

            return dp[x][y];
        }
    }


    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
//        problem.solutionWithBottomUp();
        problem.solutionWithTopDown();
    }
}
