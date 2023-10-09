package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland_827 {
    public int largestIsland(int[][] grid) {
        int[] dx = new int[] { 1, 0, -1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 2, max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = getCnt(grid, i, j, idx);

                    map.put(idx++, count);
                    max = Math.max(max, count);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int cnt = 1;
                    Set<Integer> userIdx = new HashSet<>();

                    for (int d = 0; d < 4; d++) {
                        int nx = j + dx[d], ny = i + dy[d];

                        if (nx < 0 || ny < 0 || nx >= grid[0].length || ny >= grid.length) {
                            continue;
                        }

                        if (grid[ny][nx] != 0 && !userIdx.contains(grid[ny][nx])) {
                            cnt += map.get(grid[ny][nx]);
                            userIdx.add(grid[ny][nx]);
                        }
                    }

                    max = Math.max(max, cnt);
                }
            }
        }

        return max;
    }

    private int getCnt(int[][] grid, int y, int x, int idx) {
        if (x < 0 || y < 0 || y >= grid.length || x >= grid[y].length || grid[y][x] != 1) {
            return 0;
        }

        grid[y][x] = idx;
        int cnt = 1;
        cnt += getCnt(grid, y, x + 1, idx);
        cnt += getCnt(grid, y + 1, x, idx);
        cnt += getCnt(grid, y, x - 1, idx);
        cnt += getCnt(grid, y - 1, x, idx);

        return cnt;
    }
}
