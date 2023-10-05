package programmas.java.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class ExitMazon {
    class Dot {
        public int x;
        public int y;
        public int time;

        public Dot(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        int startX = 0;
        int startY = 0;
        int leverX = 0;
        int leverY = 0;
        int exitX = 0;
        int exitY = 0;

        // 시작 위치, 레버 위치, 출구 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char cell = maps[i].charAt(j);
                if (cell == 'S') {
                    startX = j;
                    startY = i;
                } else if (cell == 'L') {
                    leverX = j;
                    leverY = i;
                } else if (cell == 'E') {
                    exitX = j;
                    exitY = i;
                }
            }
        }

        int startToLever = bfs(startX, startY, leverX, leverY, maps);
        int leverToExit = bfs(leverX, leverY, exitX, exitY, maps);

        int totalTime = startToLever + leverToExit;

        // 탈출할 수 없는 경우 -1을 반환합니다.
        if (startToLever == 0 || leverToExit == 0) {
            return -1;
        }

        return totalTime;
    }

    public int bfs(int startX, int startY, int targetX, int targetY, String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        Queue<Dot> que = new LinkedList<>();
        que.add(new Dot(startX, startY, 0));

        while (!que.isEmpty()) {
            Dot current = que.poll();

            if (current.x == targetX && current.y == targetY) {
                return current.time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 범위 내에 있고, 통로 또는 출구 또는 레버이며 아직 방문하지 않은 경우
                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;
                if (visited[ny][nx])
                    continue;
                if (maps[ny].charAt(nx) == 'O' || maps[ny].charAt(nx) == 'L' || maps[ny].charAt(nx) == 'E'
                        || maps[ny].charAt(nx) == 'S') {
                    visited[ny][nx] = true;
                    que.add(new Dot(nx, ny, current.time + 1));
                }
            }
        }
        return 0;
    }
}
