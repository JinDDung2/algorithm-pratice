package BOJ.trend;

import java.io.*;
import java.util.*;

// [G3] 15685. 드래곤 커브

public class 드래곤커브_15685 {
    public static void main(String[] args) throws IOException {
        // 드래곤 커브 구현
        // 배열 순회 -> ture인 곳 기준으로 사각형 되는지 확인 -> 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[][] data = new boolean[101][101];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragonCurve(data, x, y, getDirections(d, g));
        }

        int result = getTotalRectangle(data);
        System.out.println(result);
        br.close();
    }

    private static void dragonCurve(boolean[][] data, int x, int y, List<Integer> directions) {
        // 자기 자신 true
        data[x][y] = true;
        // 방향에 따른 점 체크
        // 0: (0, 1) | 1: (-1, 0) | 2 : (0, -1) | 3 : (1, 0)
        for (int direction : directions) {
            switch (direction) {
                case 0:
                    data[++x][y] = true;
                    break;
                case 1:
                    data[x][--y] = true;
                    break;
                case 2:
                    data[--x][y] = true;
                    break;
                case 3:
                    data[x][++y] = true;
                    break;
            }
        }
    }

    private static List<Integer> getDirections(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        while (g-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int direction = (directions.get(i) + 1) % 4;
                directions.add(direction);
            }
        }

        return directions;
    }

    private static int getTotalRectangle(boolean[][] data) {
        int n = data.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (data[i][j] && data[i + 1][j] && data[i][j + 1] && data[i + 1][j + 1]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
