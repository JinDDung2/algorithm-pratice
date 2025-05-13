package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P2618_경찰차 {

    static class Problem {

        int N, W;
        int[][] events;
        int[][] dp;
        int[][] trace;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            W = Integer.parseInt(br.readLine());

            events = new int[W + 1][2];
            for (int i = 1; i <= W; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                events[i][0] = Integer.parseInt(st.nextToken());
                events[i][1] = Integer.parseInt(st.nextToken());
            }

            dp = new int[W + 1][W + 1];
            trace = new int[W + 1][W + 1];
            for (int[] r : dp) {
                Arrays.fill(r, -1);
            }

            int result = solve(0, 0);
            bw.write(result + "\n");

            int a = 0, b = 0;
            for (int next = 1; next <= W; next++) {
                int who = trace[a][b];
                bw.write(who + "\n");
                if (who == 1) a = next;
                else b = next;
            }

            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int a, int b) {
            int next = Math.max(a, b) + 1;

            if (next > W) return 0;
            if (dp[a][b] != -1) return dp[a][b];

            int distA = solve(next, b) + getDist(a, next, 1);
            int distB = solve(a, next) + getDist(b, next, 2);

            if (distA <= distB) {
                dp[a][b] = distA;
                trace[a][b] = 1;
            } else {
                dp[a][b] = distB;
                trace[a][b] = 2;
            }

            return dp[a][b];
        }

        int getDist(int from, int to, int who) {
            int x1, y1;

            if (from == 0) {
                if (who == 1) {
                    x1 = 1; y1 = 1;
                } else {
                    x1 = N; y1 = N;
                }
            } else {
                x1 = events[from][0];
                y1 = events[from][1];
            }

            int x2 = events[to][0];
            int y2 = events[to][1];

            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
