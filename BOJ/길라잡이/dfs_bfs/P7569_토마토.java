package BOJ.길라잡이.dfs_bfs;

import java.io.*;
import java.util.*;

public class P7569_토마토 {

    static class Problem {

        int N, M, H;
        int[][][] data;
        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        int days = -1;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            data = new int[H][N][M];

            for (int k = 0; k < H; k++) {
                for (int i = 0; i < N; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < M; j++) {
                        data[k][i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }

            bfs();
            if (isValid()) {
                System.out.println(days);
            } else {
                System.out.println(-1);
            }
        }

        void bfs() {
            List<int[]> items = new ArrayList<>();
            for (int k = 0; k < H; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (data[k][i][j] == 1) items.add(new int[]{i, j, k});
                    }
                }
            }

            Queue<int[]> que = new LinkedList<>(items);
            while (!que.isEmpty()) {
                int size = que.size();
                days++;

                for (int i = 0; i < size; i++) {
                    int[] curr = que.poll();
                    int x = curr[0], y = curr[1], z = curr[2];

                    for (int d = 0; d < 6; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        int nz = z + dz[d];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
                        if (data[nz][nx][ny] != 0) continue;

                        data[nz][nx][ny] = 1;
                        que.add(new int[]{nx, ny, nz});
                    }
                }
            }
        }

        boolean isValid() {
            for (int k = 0; k < H; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (data[k][i][j] == 0) return false;
                    }
                }
            }

            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
