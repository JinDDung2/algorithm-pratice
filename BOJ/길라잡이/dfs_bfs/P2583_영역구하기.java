package BOJ.길라잡이.dfs_bfs;

import java.io.*;
import java.util.*;

public class P2583_영역구하기 {

    static class Problem {

        int M, N, K;
        int[][] data;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        List<Integer> result = new ArrayList<>();

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            data = new int[M][N];


            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                for (int i = y1; i < y2; i++) {
                    for (int j = x1; j < x2; j++) {
                        data[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (data[i][j] == 0) {
                        bfs(i, j);
                    }
                }
            }

            Collections.sort(result);
            bw.write(result.size() + "\n");

            for (int n : result) {
                bw.write(n + " ");
            }

            bw.flush();
            bw.close();
            br.close();
        }

        void bfs(int x, int y) {
            Queue<int[]> que = new LinkedList<>();
            que.add(new int[]{x, y});
            data[x][y] = 1; // 시작 지점 방문 처리
            int cnt = 1;

            while (!que.isEmpty()) {
                int[] curr = que.poll();
                int cx = curr[0], cy = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                    if (data[nx][ny] == 1) continue;

                    data[nx][ny] = 1;
                    que.add(new int[]{nx, ny});
                    cnt++;
                }
            }

            result.add(cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
