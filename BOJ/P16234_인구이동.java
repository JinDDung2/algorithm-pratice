package BOJ;

import java.io.*;
import java.util.*;

public class P16234_인구이동 {
    static class Problem {

        int N, L, R;
        int[][] data;
        boolean[][] visited;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            data = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int days = 0;

            while (true) {
                visited = new boolean[N][N];
                boolean isMoved = false;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!visited[i][j]) {
                            List<int[]> union = bfs(i, j);
                            if (union.size() > 1) {
                                isMoved = true;
                                int sum = 0;
                                for (int[] node : union) {
                                    sum += data[node[0]][node[1]];
                                }

                                int avg = sum / union.size();
                                for (int[] node : union) {
                                    data[node[0]][node[1]] = avg;
                                }
                            }
                        }
                    }
                }

                if (!isMoved) break;
                days++;
            }

            bw.write(String.valueOf(days));
            bw.flush();
            bw.close();
            br.close();
        }

        List<int[]> bfs(int x, int y) {
            Queue<int[]> que = new LinkedList<>();
            List<int[]> list = new ArrayList<>();

            que.offer(new int[]{x, y});
            list.add(new int[]{x, y});
            visited[x][y] = true;

            while (!que.isEmpty()) {
                int[] curr = que.poll();
                int currX = curr[0], currY = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nx = currX + dx[d];
                    int ny = currY + dy[d];

                    if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                        int diff = Math.abs(data[currX][currY] - data[nx][ny]);
                        if (L <= diff && diff <= R) {
                            visited[nx][ny] = true;
                            que.offer(new int[]{nx, ny});
                            list.add(new int[]{nx, ny});
                        }
                    }
                }
            }

            return list;
        }
    }


    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
