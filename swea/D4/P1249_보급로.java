package swea.D4;

import java.io.*;
import java.util.*;

/**
 * 1. bfs 탐색 -> 입력받을 data 배열, 시간의 누적합 dist배열(MAX값으로 초기화)
 * 2-0. 현재 경로가 해당 위치의 누적합 보다 크면 탐색 종료
 * 2-2. 현재 경로가 해당 위치의 누적합 보다 작고,
 *      배열 범위 내에 있으며,
 *      추가된 비용이 이동할 위치의 누적합보다 작을 경우 큐에 추가
 */

public class P1249_보급로 {

    static int T, N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            int[][] data = new int[N][N];
            int[][] dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    data[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE; // dist 배열 초기화
                }
            }

            int result = bfs(data, dist);
            System.out.printf("#%d %d\n", test_case, result);
        }
    }

    static int bfs(int[][] data, int[][] dist) {
        PriorityQueue<Node> que = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        que.add(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!que.isEmpty()) {
            Node curr = que.poll();

            // 현재 경로가 최단 거리보다 크면 스킵
            if (curr.cost > dist[curr.x][curr.y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (isValidPath(nx, ny)) {
                    int newCost = curr.cost + data[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        que.add(new Node(nx, ny, newCost));
                    }
                }
            }
        }

        return dist[N - 1][N - 1];
    }

    static boolean isValidPath(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static class Node {
        int x, y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

}
