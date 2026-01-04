package programmas.java.lv2;

import java.util.*;

// 2025 프로그래머스 코드챌린지 1차 예선 지게차와 크레인
public class ForkliftsAndCranes {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        // 1. 패딩 포함 맵 생성
        char[][] map = new char[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], '0');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        // 2. 요청 처리
        for (String req : requests) {
            char target = req.charAt(0);

            // 2-1. 크레인 (전부 제거)
            if (req.length() == 2) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (map[i][j] == target) {
                            map[i][j] = '0';
                        }
                    }
                }
                continue;
            }

            // 2-2. 지게차 (외부 접근 가능만 제거)
            boolean[][] outside = markOutsideAir(map, n, m);
            List<int[]> removeList = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (map[i][j] != target) continue;

                    if (isAccessible(outside, i, j)) {
                        removeList.add(new int[]{i, j});
                    }
                }
            }

            for (int[] pos : removeList) {
                map[pos[0]][pos[1]] = '0';
            }
        }

        // 3. 남은 컨테이너 개수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != '0') answer++;
            }
        }

        return answer;
    }

    // 외부 공기 BFS
    boolean[][] markOutsideAir(char[][] map, int n, int m) {
        boolean[][] outside = new boolean[n + 2][m + 2];
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0, 0});
        outside[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2) continue;
                if (outside[nx][ny]) continue;
                if (map[nx][ny] != '0') continue;

                outside[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        return outside;
    }

    boolean isAccessible(boolean[][] outside, int x, int y) {
        return outside[x - 1][y] ||
                outside[x + 1][y] ||
                outside[x][y - 1] ||
                outside[x][y + 1];
    }
}
