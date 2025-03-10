package BOJ;

import java.io.*;
import java.util.*;

public class P2467_용액 {

    static class Problem {

        /**
         * 여러개의 노드와 각각의 간선에 대한 비용이 존재.
         * 최소한의 비용으로 목적지에 도달 -> 다익스트라
         */
        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // <= 50,000
            int M = Integer.parseInt(st.nextToken()); // <= 50,000

            List<List<Node>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph.get(from).add(new Node(to, cost));
                graph.get(to).add(new Node(from, cost));
            }

            // 1에서 시작
            // 가지 못하는 경우 X
            int[] distances = dijkstra(1, graph);
            bw.write(String.valueOf(distances[N]));
            br.close();
            bw.flush();
            bw.close();
        }

        int[] dijkstra(int start, List<List<Node>> graph) {
            int[] distances = new int[graph.size()];
            Arrays.fill(distances, Integer.MAX_VALUE);

            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cost, n2.cost));
            distances[start] = 0;
            pq.offer(new Node(1, 0));

            while(!pq.isEmpty()) {
                Node curr = pq.poll();
                int currIdx = curr.index;
                int currCost = curr.cost;

                if (currCost > distances[currIdx]) continue;

                for (Node next : graph.get(currIdx)) {
                    int cost = currCost + next.cost;
                    if (cost < distances[next.index]) {
                        distances[next.index] = cost;
                        pq.offer(new Node(next.index, cost));
                    }
                }
            }

            return distances;
        }
    }

    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
