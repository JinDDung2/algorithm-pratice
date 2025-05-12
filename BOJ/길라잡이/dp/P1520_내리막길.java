package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P1520_내리막길 {

    static class Problem {

        int N, M;
        int[][] board;
        int[][] dp;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        void solutionWithTopDown() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp = new int[N][M];
            for (int[] d : dp) {
                Arrays.fill(d, -1);
            }

            int result = solve(0, 0);
            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int x, int y) {
            if (x == N - 1 && y == M - 1) return 1;
            if (dp[x][y] != -1) return dp[x][y];

            dp[x][y] = 0;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (board[nx][ny] < board[x][y]) {
                    dp[x][y] += solve(nx, ny);
                }
            }

            return dp[x][y];
        }

        void solutionWithBottomUp() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    nodes.add(new Node(i, j, board[i][j]));
                }
            }
            dp = new int[N][M];
            dp[0][0] = 1;
            nodes.sort((n1, n2) -> n2.h - n1.h);
            for (Node node : nodes) {
                int x = node.x;
                int y = node.y;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (board[nx][ny] < board[x][y]) {
                        dp[nx][ny] += dp[x][y];
                    }

                }
            }

            bw.write(String.valueOf(dp[N - 1][M - 1]));
            bw.flush();
            bw.close();
            br.close();
        }

    }

    static class Node {
        int x, y, h;

        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
//        problem.solutionWithTopDown();
        problem.solutionWithBottomUp();
    }
}
