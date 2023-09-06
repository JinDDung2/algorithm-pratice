package programmas.java.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class RecobhatRobot {
    private final int[] dx = { -1, 1, 0, 0 };
    private final int[] dy = { 0, 0, -1, 1 };

    private final char ROBOT = 'R', DISABLE = 'D', GOAL = 'G';

    private int n, m;

    private class Moving {
        int x, y, depth;

        public Moving(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int solution(String[] board) {
        int answer = 0;

        n = board.length;
        m = board[0].length();

        Moving robot = null;
        Moving goal = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = board[i].charAt(j);

                if (ch == ROBOT) {
                    robot = new Moving(i, j, 0);
                } else if (ch == GOAL) {
                    goal = new Moving(i, j, 0);
                }
            }
        }

        answer = bfs(board, robot, goal);

        return answer;
    }

    private int bfs(String[] board, Moving robot, Moving goal) {
        Queue<Moving> que = new LinkedList<>();
        que.add(robot);
        boolean[][] visited = new boolean[n][m];
        visited[robot.x][robot.y] = true;

        while (!que.isEmpty()) {
            Moving move = que.poll();

            if (move.x == goal.x && move.y == goal.y) {
                return move.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = move.x;
                int ny = move.y;

                // 범위를 벗어나거나 장애물을 만날 때 까지 반복
                while (inRange(nx, ny) && board[nx].charAt(ny) != DISABLE) {
                    nx += dx[i];
                    ny += dy[i];
                }

                // 범위를 벗어나거나 장애물 만나기 '직전'의 상태
                nx -= dx[i];
                ny -= dy[i];

                // 방문을 하거나 같은 위치일 경우 스킵
                if (visited[nx][ny] || (move.x == nx && move.y == ny))
                    continue;

                visited[nx][ny] = true;
                que.add(new Moving(nx, ny, move.depth + 1));
            }
        }

        return -1;
    }

    private boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
