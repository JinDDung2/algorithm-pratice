package BOJ.길라잡이.dfs_bfs;

import java.io.*;
import java.util.*;

public class P2206_벽부수고이동하기 {

    static class Problem {

        int N, M;
        int[][] data;
        int[][][] dp;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            data = new int[N][M];
            dp = new int[N][M][2]; // [x][y][부순 적 없는 경로, 부순 적 있는 경로]

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    data[i][j] = input.charAt(j) - '0';
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);
                }
            }

            dp[0][0][0] = dp[0][0][1] = 1;

            bfs();
            int result = Math.min(dp[N - 1][M - 1][0], dp[N - 1][M - 1][1]);
            System.out.println(result == Integer.MAX_VALUE ? -1 : result);
        }

        void bfs() {
            Queue<int[]> que = new LinkedList<>();
            que.add(new int[]{0, 0, 0});

            while (!que.isEmpty()) {
                int[] curr = que.poll();
                int x = curr[0], y = curr[1], z = curr[2];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                    if (data[nx][ny] == 0 && dp[nx][ny][z] == Integer.MAX_VALUE) {
                        dp[nx][ny][z] = dp[x][y][z] + 1;
                        que.add(new int[]{nx, ny, z});
                        continue;
                    }

                    if (data[nx][ny] == 1 && z == 0 && dp[nx][ny][1] == Integer.MAX_VALUE) {
                        dp[nx][ny][1] = dp[x][y][0] + 1;
                        que.add(new int[]{nx, ny, 1});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
