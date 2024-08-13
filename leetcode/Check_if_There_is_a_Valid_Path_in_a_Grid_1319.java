package leetcode;

import java.util.*;

// 1391. Check if There is a Valid Path in a Grid

public class Check_if_There_is_a_Valid_Path_in_a_Grid_1319 {

    // 좌 -> 우, 우 -> 좌
    // 상 -> 하, 하 -> 상
    // 좌 -> 하, 하 -> 좌
    // 하 -> 우, 우 -> 하
    // 좌 -> 상, 상 -> 좌
    // 상 -> 우, 우 -> 상
    int[][][] directions = {
            {{0, 1}, {0, -1}},
            {{1, 0}, {-1, 0}},
            {{1, 0}, {0, -1}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{-1, 0}, {0, 1}}
    };

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int y = curr[0], x = curr[1];
            int num = grid[y][x] - 1;

            for (int[] direction : directions[num]) {
                int ny = y + direction[0];
                int nx = x + direction[1];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (visited[ny][nx]) continue;
                for (int[] backDirection : directions[grid[ny][nx] - 1]) {
                    if (ny + backDirection[0] == y && nx + backDirection[1] == x) {
                        visited[ny][nx] = true;
                        que.add(new int[]{ny, nx});
                    }
                }
            }
        }

        return visited[n - 1][m - 1];
    }

}
