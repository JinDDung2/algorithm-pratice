package BOJ.함께블록쌓기;

import java.io.*;
import java.util.*;

public class P18427_함께블록쌓기 {
    static class Problem {
        final int MOD = 10_007;
        int N, M, H;
        List<Integer>[] blocks;

        int solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            blocks = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                blocks[i] = new ArrayList<>();
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    blocks[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            int[][] dp = new int[N + 1][H + 1];
            dp[0][0] = 1;

            for (int i = 1; i <= N; i++) {
                for (int h = 0; h <= H; h++) {
                    // 블록 선택 안하는 경우
                    dp[i][h] = dp[i - 1][h];
                    // 블록 하나 선택
                    for (int block : blocks[i]) {
                        if (h >= block) {
                            dp[i][h] = (dp[i][h] + dp[i - 1][h - block]) % MOD;
                        }
                    }
                }
            }

            return dp[N][H];
        }

        int[][] dp2;
        int solutionV2() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            blocks = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                blocks[i] = new ArrayList<>();
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    blocks[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            dp2 = new int[N][H + 1];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp2[i], -1);
            }

            return dfs(0, H);
        }

        int dfs(int i, int h) {
            if (h == 0) return 1;
            if (i == N) return 0;

            if (dp2[i][h] != -1) return dp2[i][h];

            int result = 0;

            // 선택 안하는 경우
            result = dfs(i + 1, h) % MOD;

            // 선택 하는 경우
            for (int block : blocks[i]) {
                if (h >= block) {
                    result = (result + dfs(i + 1, h - block)) % MOD;
                }
            }

            return dp2[i][h] = result;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        System.out.println(problem.solution());
        System.out.println(problem.solutionV2());
    }
}
