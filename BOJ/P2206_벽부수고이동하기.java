package BOJ;

import java.io.*;
import java.util.*;

public class P2206_벽부수고이동하기 {
    /**
     * 0: 이동가능, 1: 벽
     * 벽은 최대 1개까지 부술 수 있음
     * bfs
     * 4방향 이동할 때, 벽이 없다면 다음 곳 이동 후 +1
     * 벽이 있다면 [ny][nx][1] = [y][x][0] + 1
     * 3차원배열 [y][x][0] = 벽을 부수지 않은 상태의 최단거리
     * 3차원배열 [y][x][1] = 벽을 1번 부순 상태의최단거리
     */
    static class Solution {
        int n, m;
        int[][] data;
        boolean[][][] visited;
        int[][][] dist;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n, m;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            data = new int[n][m];
            visited = new boolean[n][m][2];
            dist = new int[n][m][2];
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                for (int j = 0; j < m; j++) {
                    data[i][j] = input.charAt(j) - '0';
                }
            }

            dist[0][0][0] = dist[0][0][1] = 1;
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{0, 0, 0});
            visited[0][0][0] = true;

            while (!que.isEmpty()) {
                int[] cur = que.poll();
                int y = cur[0];
                int x = cur[1];
                int z = cur[2];

                if (y == n - 1 && x == m - 1) {
                    return dist[y][x][z];
                }

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx][z]) continue;
                    if (data[ny][nx] == 0) {
                        dist[ny][nx][z] = dist[y][x][z] + 1;
                        visited[ny][nx][z] = true;
                        que.offer(new int[]{ny, nx, z});
                        continue;
                    }

                    if (data[ny][nx] == 1 && z == 0) {
                        dist[ny][nx][1] = dist[y][x][0] + 1;
                        visited[ny][nx][1] = true;
                        que.offer(new int[]{ny, nx, 1});
                    }
                }
            }

            return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.solution());
    }
}
