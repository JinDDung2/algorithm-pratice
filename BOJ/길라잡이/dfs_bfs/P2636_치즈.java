package BOJ.길라잡이.dfs_bfs;

import java.io.*;
import java.util.*;

public class P2636_치즈 {

    static class Problem {

        int N, M;
        int[][] data;
        boolean[][] visited;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            data = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int time = 0;
            int lastCount = 0;

            while (true) {
                int cheese = countCheese();
                if (cheese == 0) break;

                lastCount = cheese;
                meltingCheese();
                time++;
            }

            System.out.println(time);
            System.out.println(lastCount);
        }

        void meltingCheese() {
            visited = new boolean[N][M];
            Queue<int[]> que = new LinkedList<>();
            que.add(new int[]{0, 0});
            visited[0][0] = true;

            while (!que.isEmpty()) {
                int[] curr = que.poll();
                int x = curr[0], y = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

                    visited[nx][ny] = true;

                    if (data[nx][ny] == 1) {
                        data[nx][ny] = 0;
                    } else {
                        que.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int countCheese() {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (data[i][j] == 1) cnt++;
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
