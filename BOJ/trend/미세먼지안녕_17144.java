package BOJ.trend;

import java.io.*;
import java.util.*;

// [G4] 17144. 미세먼지 안녕!
public class 미세먼지안녕_17144 {
    static class Node {
        int y;
        int x;
        int dust;

        public Node(int y, int x, int dust) {
            this.y = y;
            this.x = x;
            this.dust = dust;
        }
    }

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int robot = -1;
    // static Queue<Node> que;

    public static void main(String[] args) throws IOException {
        // 공기청정기 없음 빈칸일 때 -> 미세먼지 4방향 확산, 양 (미세먼지/5) + 현재위치 미세먼지 = 현재위치 미세먼지 - (방향횟수 *
        // 미세먼지 / 5)
        // 미세먼지 -> 큐에 저장해서 확산
        // 공기청정기 작동 -> 미세먼지 모두 바람 방향대로 한 칸씩 이동
        // 공기청정기는 이동안함. 바로 옆에는 미세먼지 0
        // 위쪽: 반시계
        // 아래쪽: 시계
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] data = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == -1) {
                    robot = i; // r2 = i, r1 = r2 - 1;
                }
            }
        }

        while (T-- > 0) {
            List<Node> dusts = getCanSpreadDusts(data);

            spreadDust(data, dusts);

            // for (int[] d : data) {
            // System.out.println(Arrays.toString(d));
            // }

            operateAirCleaner(data);

            // for (int[] d : data) {
            // System.out.println(Arrays.toString(d));
            // }
        }

        int result = getAmountOfFineDust(data);
        System.out.println(result);
        br.close();

    }

    private static List<Node> getCanSpreadDusts(int[][] data) {
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] >= 5) {
                    list.add(new Node(i, j, data[i][j]));
                }
            }
        }

        return list;
    }

    private static void spreadDust(int[][] data, List<Node> dusts) {
        Queue<Node> que = new LinkedList<>(dusts);

        while (!que.isEmpty()) {
            Node curr = que.poll();

            int amountOfDusts = curr.dust / 5;
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= data.length || nx >= data[0].length)
                    continue;
                if (data[ny][nx] == -1)
                    continue;

                data[ny][nx] += amountOfDusts;
                cnt++;
            }
            data[curr.y][curr.x] -= (amountOfDusts * cnt);
        }
    }

    private static void operateAirCleaner(int[][] data) {
        int top = robot - 1;
        int down = robot;
        int r = data.length;
        int c = data[0].length;

        // top 반시계
        // 하
        for (int i = top - 1; i > 0; i--) {
            data[i][0] = data[i - 1][0];
        }
        // 좌
        for (int i = 0; i < c - 1; i++) {
            data[0][i] = data[0][i + 1];
        }
        // 상
        for (int i = 0; i < top; i++) {
            data[i][c - 1] = data[i + 1][c - 1];
        }
        // 우
        for (int i = c - 1; i >= 2; i--) {
            data[top][i] = data[top][i - 1];
        }
        data[top][1] = 0;
        // down 시계
        // 상
        for (int i = down + 1; i < r - 1; i++) {
            data[i][0] = data[i + 1][0];
        }
        // 좌
        for (int i = 0; i < c - 1; i++) {
            data[r - 1][i] = data[r - 1][i + 1];
        }
        // 하
        for (int i = r - 1; i >= down + 1; i--) {
            data[i][c - 1] = data[i - 1][c - 1];
        }
        // 우
        for (int i = c - 1; i > 0; i--) {
            data[down][i] = data[down][i - 1];
        }
        data[down][1] = 0;
    }

    private static int getAmountOfFineDust(int[][] data) {
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] > 0) {
                    result += data[i][j];
                }
            }
        }

        return result;
    }
}
