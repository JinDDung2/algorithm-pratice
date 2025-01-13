package BOJ;

import java.io.*;
import java.util.*;

public class P1446_지름길 {

    static class Problem {

        static class ShortCut {
            int start;
            int end;
            int distance;

            public ShortCut(int s, int e, int d) {
                this.start = s;
                this.end = e;
                this.distance = d;
            }

            public ShortCut(int e, int d) {
                this.end = e;
                this.distance = d;
            }

            @Override
            public String toString() {
                return String.format("{s=%d, e=%d, d=%d}", start, end, distance);
            }
        }

        // DP: O(D * N)
        // 직선 거리와 지름길 정보를 활용해 배열에 최소 거리 정보를 업데이트.
        // 단순히 왼쪽에서 오른쪽으로 한 번만 진행하므로 직관적.
        int solutionDP() throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // <= 12
            int D = Integer.parseInt(st.nextToken()); // <= 10_000

            List<ShortCut> shorCuts = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                // 유효한 지름길만 추가
                if (e <= D && e - s > d) {
                    shorCuts.add(new ShortCut(s, e, d));
                }
            }

            int[] dp = new int[D + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 0; i <= D; i++) {
                dp[i] = (i == 0 ? dp[i] = 0 : Math.min(dp[i], dp[i - 1] + 1));
                for (ShortCut shortCut : shorCuts) {
                    if (shortCut.start == i) { // 현재 위치에서 지름길 사용 가능한지
                        dp[shortCut.end] = Math.min(dp[shortCut.end], dp[shortCut.start] + shortCut.distance);
                    }
                }
            }

            return dp[D];
        }

        // 다익스트라: O((N+D)logD)
        // 그래프처럼 구성해 시작 노드에서 모든 노드의 최소 거리를 계산.
        // 우선순위 큐를 사용해 효율적으로 최소 거리 업데이트.
        int solutionDijkstra() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // <= 12
            int D = Integer.parseInt(st.nextToken()); // <= 10_000

            List<ShortCut>[] graph = new ArrayList[D + 1];
            for (int i = 0; i <= D; i++) {
                graph[i] = new ArrayList<>();
                if (i < D) graph[i].add(new ShortCut(i + 1, 1));
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                // 유효한 지름길만 추가
                if (e <= D && e - s > d) {
                    graph[s].add(new ShortCut(e, d));
                }
            }

            int[] distances = new int[D + 1];
            Arrays.fill(distances, Integer.MAX_VALUE);

            PriorityQueue<ShortCut> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));
            pq.add(new ShortCut(0, 0));
            distances[0] = 0;

            while (!pq.isEmpty()) {
                ShortCut curr = pq.poll();

                if (distances[curr.end] < curr.distance) continue;

                for (ShortCut next : graph[curr.end]) {
                    if (distances[next.end] > distances[curr.end] + next.distance) {
                        distances[next.end] = distances[curr.end] + next.distance;
                        pq.add(new ShortCut(next.end, distances[next.end]));
                    }
                }
            }

            return distances[D];
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
//        System.out.println(p.solutionDP());
        System.out.println(p.solutionDijkstra());
    }
}
