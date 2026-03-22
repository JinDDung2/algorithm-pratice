package BOJ;

import java.io.*;
import java.util.*;

// 1915. 가장 큰 정사각형
public class P1915_가장큰정사각형 {
    /**
     * a, b 지점을 기준으로 a, b가 1이면 (a - 1, b) || (a, b - 1) || (a - 1, b - 1) 세 개중 가장 낮은 정사각형 개수 + 1
     * 누적합을 저장해야 한다 -> dp
     */
    static class Solution {
        int N, M;
        char[][] graph;
        int[][] dp;

        int solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new char[N][M];
            for (int i = 0; i < N; i++) {
                graph[i] = br.readLine().strip().toCharArray();
            }
            dp = new int[N + 1][M + 1];
            int result = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (graph[i - 1][j - 1] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1],
                                Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }

            return result * result;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.solution());
    }
}
