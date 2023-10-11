package programmas.java.lv3;

import java.util.*;

class Solution {
    class Move {
        int x, y, dir, cost;

        public Move(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public int solution(int[][] board) {
        int answer = bfs(board);
        return answer;
    }

    private int bfs(int[][] board) {
        final int N = board.length;
        int[][][] visited = new int[N][N][4];
        int[] dx = new int[] { 1, 0, -1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Move> que = new LinkedList<>();
        que.add(new Move(0, 0, -1, 0));

        while (!que.isEmpty()) {
            Move curr = que.poll();

            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[ny][nx] == 1) {
                    continue;
                }

                int nCost = curr.cost + (curr.dir == -1 ? 100 : (curr.dir == d ? 100 : 600));

                if (visited[ny][nx][d] == 0 || visited[ny][nx][d] > nCost) {
                    visited[ny][nx][d] = nCost;
                    que.add(new Move(nx, ny, d, nCost));
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            if (visited[N - 1][N - 1][d] > 0) {
                minCost = Math.min(minCost, visited[N - 1][N - 1][d]);
            }
        }

        return minCost;
    }
}

// 1트 실패
// class ConstructRoad {

// private static final int[] dx = { 1, -1, 0, 0 };
// private static final int[] dy = { 0, 0, 1, -1 };

// private class Road {
// public final int x;
// public final int y;
// public final int cost;
// public final Road prev;

// public Road(int x, int y, int cost, Road prev) {
// this.x = x;
// this.y = y;
// this.cost = cost;
// this.prev = prev;
// }
// }

// private int bfs(int[][] roads) {
// int result = Integer.MAX_VALUE;
// int size = roads.length - 1;

// Queue<Road> q = new LinkedList<>();
// q.add(new Road(0, 0, 0, null));

// while (!q.isEmpty()) {
// Road current = q.poll();

// if (current.x == size && current.y == size) {
// if (current.cost < result)
// result = current.cost;
// continue;
// }

// for (int i = 0; i < 4; i++) {
// int nx = current.x + dx[i];
// int ny = current.y + dy[i];

// if (nx < 0 || nx > size || ny < 0 || ny > size || roads[ny][nx] == 1)
// continue;

// int cost = 100;
// if (current.prev != null && current.prev.x != nx && current.prev.y != ny)
// cost += 500;
// cost += current.cost;

// if (roads[ny][nx] >= cost) {
// roads[ny][nx] = cost;
// q.add(new Road(nx, ny, cost, current));
// } else if (roads[ny][nx] + 500 >= cost) {
// q.add(new Road(nx, ny, cost, current));
// }
// }
// }

// return result;
// }

// public int solution(int[][] board) {
// int size = board.length - 1;
// for (int i = 0; i <= size; i++) {
// for (int j = 0; j <= size; j++) {
// if (board[i][j] == 1)
// continue;
// board[i][j] = Integer.MAX_VALUE;
// }
// }
// board[0][0] = 0;
// return bfs(board);
// }
// }