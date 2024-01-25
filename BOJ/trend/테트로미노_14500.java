package BOJ.trend;

import java.io.*;
import java.util.*;

// [G4] 14500. 테트로미노
public class 테트로미노_14500 {
    static int result = 0;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        /*
         * // N, M 입력받기
         * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         * StringTokenizer st;
         * st = new StringTokenizer(br.readLine());
         * final int N = Integer.parseInt(st.nextToken());
         * final int M = Integer.parseInt(st.nextToken());
         * // 데이터 2차원 배열로 저장
         * // visited
         * int[][] data = new int[N][M];
         * boolean[][] visited = new boolean[N][M];
         * for (int i = 0; i < N; i++) {
         * st = new StringTokenizer(br.readLine());
         * for (int j = 0; j < M; j++) {
         * data[i][j] = Integer.parseInt(st.nextToken());
         * }
         * }
         * 
         * // 모든 위치 반복
         * // 탐색을 통해 테트로미노 모양인지 -> cnt = 4
         * // cnt = 4 -> Math.max(result, 계산한 값)
         * // 단 보라색 경우가 안나옴 -> cnt = 2 일떄 재귀를 돌려
         * for (int i = 0; i < N; i++) {
         * for (int j = 0; j < M; j++) {
         * visited[i][j] = true;
         * dfs(data, visited, i, j, data[i][j], 1);
         * visited[i][j] = false;
         * }
         * }
         * 
         * System.out.println(result);
         * br.close();
         */

        mainV2();
    }

    private static void dfs(int[][] data, boolean[][] visited, int y, int x, int sum, int cnt) {
        int n = data.length;
        int m = data[0].length;
        if (cnt == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;

            if (!visited[ny][nx]) {
                // 보라색
                if (cnt == 2) {
                    visited[ny][nx] = true;
                    dfs(data, visited, y, x, sum + data[ny][nx], cnt + 1);
                    visited[ny][nx] = false;
                }

                visited[ny][nx] = true;
                dfs(data, visited, ny, nx, sum + data[ny][nx], cnt + 1);
                visited[ny][nx] = false;
            }
        }
    }

    public static void mainV2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] data = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 한 점을 시작으로 4개의 칸 반복 탐색
        // dfs -> 4번 탐색 but 보라색은 cnt = 2 일떄 dfs 탐색하기 전 한번 더 탐색한다는 조건 추가

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfsV2(data, visited, i, j, data[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void dfsV2(int[][] data, boolean[][] visited, int y, int x, int sum, int cnt) {
        if (cnt == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= data.length || nx >= data[0].length || visited[ny][nx])
                continue;

            if (cnt == 2) {
                visited[ny][nx] = true;
                dfsV2(data, visited, y, x, sum + data[ny][nx], cnt + 1);
                visited[ny][nx] = false;
            }

            visited[ny][nx] = true;
            dfsV2(data, visited, ny, nx, sum + data[ny][nx], cnt + 1);
            visited[ny][nx] = false;
        }
    }
}
