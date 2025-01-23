package BOJ;

import java.io.*;
import java.util.*;

public class P13549_숨바꼭질 {
    static class Problem {

        static final int MAX_NUM = 100_000;
        int solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new  StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // <= 100,000
            int M = Integer.parseInt(st.nextToken()); // <= 100,000

            // 수빈이가 동생보다 앞서 있다면 뺼셈만 가능 == N - M
            if (N >= M) return N - M;

            // 우선순위 큐. 비용 낮은 순
            // X - 1 : 위치 > 0 && 기록된 비용값 > 현재위치의 비용 + 1
            // X + 1 : 위치 <= 100,000 && 기록된 비용값 > 현재위치의 비용 + 1
            // X * 2 : 위치 <= 200,000 && 기록된 비용값 > 현재위치의 비용
            int[] costs = new int[2 * MAX_NUM + 1];
            Arrays.fill(costs, MAX_NUM);
            PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
            pq.add(new Point(N, 0));

            while (!pq.isEmpty()) {
                Point curr = pq.poll();
                int position = curr.position;
                int cost = curr.cost;

                if (position == M) return costs[M];
                if (cost > costs[position]) continue;

                int plusPosition = position + 1;
                int minusPosition = position - 1;
                int doublePosition = position * 2;

                if (plusPosition <= MAX_NUM && costs[plusPosition] > cost + 1) {
                    costs[plusPosition] = cost + 1;
                    pq.add(new Point(plusPosition, costs[plusPosition]));
                }

                if (minusPosition >= 0 && costs[minusPosition] > cost + 1) {
                    costs[minusPosition] = cost + 1;
                    pq.add(new Point(minusPosition, costs[minusPosition]));
                }

                if (doublePosition <= 2 * MAX_NUM && costs[doublePosition] > cost) {
                    costs[doublePosition] = cost;
                    pq.add(new Point(doublePosition, costs[doublePosition]));
                }

            }

            return -1;
        }

        static class Point {
            int position;
            int cost;

            public Point(int p, int c) {
                this.position = p;
                this.cost = c;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
