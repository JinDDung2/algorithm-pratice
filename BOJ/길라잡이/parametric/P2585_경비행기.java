package BOJ.길라잡이.parametric;

import java.io.*;
import java.util.*;

public class P2585_경비행기 {

    static class Problem {

        int N, K;
        Point[] points;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            points = new Point[N + 2];
            points[0] = new Point(0, 0);
            for (int i = 1; i <= N; i++ ) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }
            points[N + 1] = new Point(10000, 10000);

            int maxDist = getDistance(points[0], points[N + 1]);
            int l = 0, r = maxDist;
            int result = r;

            while (l <= r) {
                int m = l + (r - l) / 2;

                if (isPossible(m)) {
                    result = m;
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            br.close();
        }

        int getDistance(Point p1, Point p2) {
            int dx = p1.x - p2.x;
            int dy = p1.y - p2.y;
            double dist = Math.sqrt(
                    Math.pow(dx, 2) +
                    Math.pow(dy, 2)
            );

            return (int) Math.ceil(dist / 10.0);
        }

        boolean isPossible(int limit) {
            boolean[] visited = new boolean[N + 2];
            Queue<Node> que = new LinkedList<>();
            que.offer(new Node(0, 0));
            visited[0] = true;

            while (!que.isEmpty()) {
                Node curr = que.poll();

                if (curr.idx == N + 1 && curr.depth <= K + 1) return true;

                for (int i = 0; i < N + 2; i++) {
                    if (!visited[i] && getDistance(points[i], points[curr.idx]) <= limit) {
                        visited[i] = true;
                        que.add(new Node(i, curr.depth + 1));
                    }
                }
            }

            return false;
        }

        static class Point {
            int x, y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        static class Node {
            int idx;
            int depth;

            public Node (int i, int d) {
                this.idx = i;
                this.depth = d;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
