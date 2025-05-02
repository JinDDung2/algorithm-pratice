package BOJ.길라잡이.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7576_토마토 {
    static class Problem {

        int N, M;
        int[][] data;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int days = -1;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            data = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs();
            if (isValid()) {
                System.out.println(days);
            }  else {
                System.out.println(-1);
            }
        }

        void bfs() {
            List<int[]> items = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (data[i][j] == 1) items.add(new int[]{i, j});
                }
            }

            Queue<int[]> que = new LinkedList<>(items);
            while(!que.isEmpty()) {
                int size = que.size();
                days++;

                for (int i = 0; i < size; i++) {
                    int[] curr = que.poll();
                    int x = curr[0], y = curr[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if (data[nx][ny] != 0) continue;

                        data[nx][ny] = 1;
                        que.add(new int[]{nx, ny});
                    }
                }
            }
        }

        boolean isValid() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (data[i][j] == 0) return false;
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
