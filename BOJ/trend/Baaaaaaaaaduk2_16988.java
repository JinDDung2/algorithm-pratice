package BOJ.trend;

import java.io.*;
import java.util.*;

// [G3] 16928. Baaaaaaaaaduk2

public class Baaaaaaaaaduk2_16988 {
    static int[][] board;
    static int N, M;
    static int maxCnt;
    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N * M; i++) {
            int y1 = i / M, x1 = i % M;
            if (board[y1][x1] == 0) {
                for (int j = i + 1; j < N * M; j++) {
                    int y2 = j / M, x2 = j % M;
                    if (board[y2][x2] == 0) {
                        board[y1][x1] = 1;
                        board[y2][x2] = 1;
                        simulateBoard();
                        board[y2][x2] = 0;
                        board[y1][x1] = 0;
                    }
                }
            }
        }

        System.out.println(maxCnt);
    }

    private static void simulateBoard() {
        boolean[][] visited = new boolean[N][M];
        int score = 0;
        // 포위된 로직 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 2 && !visited[i][j]) {
                    int[] captured = { 0 };
                    if (isSurrounded(i, j, visited, captured)) {
                        score += captured[0];
                    }
                }
            }
        }
        // 포위된 바둑돌 합산
        maxCnt = Math.max(maxCnt, score);
    }

    private static boolean isSurrounded(int y, int x, boolean[][] visited, int[] captured) {
        if (y < 0 || x < 0 || y >= N || x >= M)
            return false;
        if (board[y][x] == 0)
            return false;
        if (visited[y][x])
            return true;
        visited[y][x] = true;

        boolean result = true;
        captured[0]++;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;

            if (board[ny][nx] == board[y][x] || board[ny][nx] == 0) {
                result &= isSurrounded(ny, nx, visited, captured);
            }
        }

        if (!result)
            captured[0] = 0;
        return result;
    }
}
