package programmas.kakao;

import java.util.*;

public class 등산코스정하기 {
    final int MAX_NUM = Integer.MAX_VALUE;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 지점마다 이동거리가 가장 긴 거리 -> intensity
        // 인접 리스트 만들기
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int from = path[0], to = path[1], cost = path[2];
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        // 이동할 때 비용이 낮은 경로 우선 탐색
        // pq 만들기 + 초기값 할당 + 시작점
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] costs = new int[n + 1];
        Arrays.fill(costs, MAX_NUM);
        for (int gate : gates) {
            pq.add(new Node(gate, 0));
            costs[gate] = 0;
        }
        Set<Integer> summitSet = new HashSet<>();
        for (int summit : summits) {
            summitSet.add(summit);
        }
        // 다익스트라
        int cnt = 1;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int now = curr.to, weight = curr.weight;

            // 봉우리 도착하면 탐색 그만
            if (weight > costs[now] || summitSet.contains(now))
                continue;

            for (Node nextNode : graph.get(now)) {
                int next = nextNode.to, newWeight = Math.max(weight, nextNode.weight);
                if (costs[next] > newWeight) {
                    costs[next] = newWeight;
                    pq.add(new Node(next, newWeight));
                }
            }
            // System.out.printf("cnt=%d, que=%s\n", cnt, pq);
            cnt++;
        }

        // intensity가 최소가 되는 등산코스가 여러 개라면 그 중 산봉우리 번호가 가장 낮은 것
        Arrays.sort(summits);
        int minCost = MAX_NUM, summitNode = 0;
        for (int summit : summits) {
            if (costs[summit] < minCost) {
                minCost = costs[summit];
                summitNode = summit;
            }
        }
        System.out.println(Arrays.toString(costs));

        return new int[] { summitNode, minCost };
    }

    class Node implements Comparable<Node> {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }

        @Override
        public String toString() {
            return String.format("{to=%d, weight=%d}", to, weight);
        }
    }
}
