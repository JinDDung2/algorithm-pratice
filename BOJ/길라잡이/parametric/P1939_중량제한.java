package BOJ.길라잡이.parametric;

import java.io.*;
import java.util.*;

public class P1939_중량제한 {

    static class Problem {

        int N, M;
        List<Node>[] graph;
        int start, end;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            int maxWeight = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph[a].add(new Node(b, c));
                graph[b].add(new Node(a, c));
                maxWeight = Math.max(maxWeight, c);
            }

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            int l = 1, r = maxWeight, result = 0;
            while (l <= r) {
                int m = l + (r - l) / 2;

                if (bfs(m)) {
                    result = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            br.close();
        }

        boolean bfs(int limit) {
            Queue<Integer> que = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];

            que.offer(start);
            visited[start] = true;

            while (!que.isEmpty()) {
                int curr = que.poll();

                if (curr == end) return true;

                for (Node node : graph[curr]) {
                    if (!visited[node.to] && node.weight >= limit) {
                        visited[node.to] = true;
                        que.offer(node.to);
                    }
                }
            }

            return false;
        }

        static class Node {
            int to;
            int weight;

            public Node(int t, int w) {
                this.to = t;
                this.weight = w;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
