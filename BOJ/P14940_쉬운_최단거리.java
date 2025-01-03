package BOJ;

import java.io.*;
import java.util.*;

public class P14940_쉬운_최단거리 {

    // 1000 * 1000 = 1,000,000 -> 완탐 가능
    // 각 지점에서 목표지점까지 최단거리 == 목표지점을 기준으로 다른 점들까지의 최단거리 -> bfs
    // 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1 -> bfs 완료 후 1인 곳을 -1처리

    static class Solution {

        int N, M;
        int[][] data;
        boolean[][] visited;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        void solution() throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            data = new int[N][M];
            visited = new boolean[N][M];

            // 데이터 입력
            for (int i = 0; i < N; i++) {
                StringTokenizer rowToken = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    data[i][j] = Integer.parseInt(rowToken.nextToken());
                }
            }
            // bfs 실행
            bfs();
            // 배열 전체 탐색 후 1인 곳을 -1처리
            markUnreachablePosition();
            // 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(data[i][j]).append(" ");
                }
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            br.close();
        }
        void bfs() {
            int[] startPosition = findStartPosition();
            Queue<int[]> que = new LinkedList<>();
            que.add(startPosition);
            // 목표지점은 0
            data[startPosition[0]][startPosition[1]] = 0;
            visited[startPosition[0]][startPosition[1]] = true;

            while (!que.isEmpty()) {
                int[] curr = que.poll();
                int x = curr[0];
                int y = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (visited[nx][ny] || data[nx][ny] != 1) continue;
                    data[nx][ny] = data[x][y] + 1;
                    que.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

        }

        int[] findStartPosition() {
            int x = -1, y = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (data[i][j] == 2) {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }

            return new int[]{x, y};
        }

        void markUnreachablePosition() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (data[i][j] == 1 && !visited[i][j]) {
                        data[i][j] = -1;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        Solution sol = new Solution();
        sol.solution();
    }

}
