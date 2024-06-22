package BOJ.trend;

import java.io.*;
import java.util.*;

public class 마법사상어와비바라기_21610 {

    static int N, M;
    static int[][] A;
    static boolean[][] clouds;
    static int[] dy = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] diagDx = { -1, -1, 1, 1 };
    static int[] diagDy = { 1, 1, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        clouds = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds[N - 1][0] = clouds[N - 1][1] = clouds[N - 2][0] = clouds[N - 2][1] = true;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            // 1. 4개 비구름 이동 -> 이동한 칸 += 1
            List<int[]> movedClouds = moveAndRains(d, s);
            // 2. 물복사 버그
            waterCopyBug(movedClouds);
            // 3. 구름 생성 및 제거
            generateClouds(movedClouds);

            System.out.println("-----");
            for (int[] ints : A) {
                System.out.println(Arrays.toString(ints));
            }
        }
        br.close();

        // 결과: 바구니에 들어있는 물의 양의 합
        System.out.println(getTotalWaterAmount());
    }

    private static List<int[]> moveAndRains(int d, int s) {
        List<int[]> movedClouds = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (clouds[i][j]) {
                    int ny = (i + dy[d] * s % N + N) % N;
                    int nx = (j + dx[d] * s % N + N) % N;
                    clouds[i][j] = false; // 구름 제거
                    movedClouds.add(new int[] { ny, nx });
                    A[ny][nx]++;
                }
            }
        }
        return movedClouds;
    }

    private static void waterCopyBug(List<int[]> clouds) {
        for (int[] c : clouds) {
            int y = c[0], x = c[1];
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int ny = y + diagDy[d];
                int nx = x + diagDx[d];
                if (isValid(ny, nx))
                    cnt++;
            }
            A[y][x] += cnt;
        }
    }

    private static void generateClouds(List<int[]> prevClouds) {
        boolean[][] prevCloudMap = new boolean[N][N];
        for (int[] c : prevClouds) {
            prevCloudMap[c[0]][c[1]] = true;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] >= 2 && !clouds[i][j]) {
                    clouds[i][j] = true;
                    A[i][j] -= 2;
                } else {
                    clouds[i][j] = false;
                }
            }
        }
    }

    private static int getTotalWaterAmount() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += A[i][j];
            }
        }
        return result;
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }
}
