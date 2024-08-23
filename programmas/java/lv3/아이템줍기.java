package programmas.java.lv3;

import java.util.*;

// [lv3] 아이템 줍기

public class 아이템줍기 {

    private final int MAX_COORD = 50;
    private final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 상하좌우 방향

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] map = new boolean[MAX_COORD * 2 + 1][MAX_COORD * 2 + 1];

        // 사각형 테두리와 내부 처리
        drawRectangles(map, rectangle);
        markInnerArea(map, rectangle);

        // 최단 경로 계산
        return findShortestPath(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    // 사각형의 테두리를 표시하는 메서드
    private void drawRectangles(boolean[][] map, int[][] rectangles) {
        for (int[] rect : rectangles) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                map[i][y1] = true;  // 아래쪽 테두리
                map[i][y2] = true;  // 위쪽 테두리
            }
            for (int i = y1; i <= y2; i++) {
                map[x1][i] = true;  // 왼쪽 테두리
                map[x2][i] = true;  // 오른쪽 테두리
            }
        }
    }

    // 사각형 내부를 표시하는 메서드
    private void markInnerArea(boolean[][] map, int[][] rectangles) {
        for (int[] rect : rectangles) {
            int x1 = rect[0] * 2 + 1, y1 = rect[1] * 2 + 1;
            int x2 = rect[2] * 2 - 1, y2 = rect[3] * 2 - 1;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = false; // 내부는 통과 불가
                }
            }
        }
    }

    // BFS로 최단 경로를 찾는 메서드
    private int findShortestPath(boolean[][] map, int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[MAX_COORD * 2 + 1][MAX_COORD * 2 + 1];
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], distance = current[2];

            if (x == endX && y == endY) {
                return distance / 2;  // 좌표가 2배 확장되었으므로 거리도 2배로 계산됨
            }

            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0], ny = y + direction[1];
                if (isValidMove(map, visited, nx, ny)) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }

    // 유효한 움직임인지 확인하는 메서드
    private boolean isValidMove(boolean[][] map, boolean[][] visited, int x, int y) {
        return x >= 0 && y >= 0 && x <= MAX_COORD * 2 && y <= MAX_COORD * 2 && map[x][y] && !visited[x][y];
    }

}
