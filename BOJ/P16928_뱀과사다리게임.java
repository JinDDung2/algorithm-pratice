package BOJ;

import java.io.*;
import java.util.*;

public class P16928_뱀과사다리게임 {
    static class Problem {

        int N, M;
        Map<Integer, Integer> ladders = new HashMap<>();
        Map<Integer, Integer> snakes = new HashMap<>();
        boolean[] visited = new boolean[101];

        int solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 데이터 입력
            // upgrade -> ladder, downgrade -> snake
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                // 이미 주어진 key라면? e가 큰 값으로
                if (!ladders.containsKey(s)) {
                    ladders.put(s, e);
                } else {
                    if (e > ladders.get(s)) {
                        ladders.put(s, e);
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                snakes.put(s, e);
            }

            return bfs();
        }

        int bfs() {
            Queue<Node> que = new LinkedList<>();
            que.add(new Node(1, 0));
            visited[1] = true;

            while(!que.isEmpty()) {
                Node curr = que.poll();
                int position = curr.position;
                int steps = curr.steps;

                if (position == 100) return steps;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = position + dice;
                    if (next > 100) continue;

                    if (ladders.containsKey(next)) {
                        next = ladders.get(next);
                    } else if (snakes.containsKey(next)) {
                        next = snakes.get(next);
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        que.add(new Node(next, steps + 1));
                    }
                }
            }

            return -1;
        }

        static class Node {
            int position;
            int steps;

            public Node(int p, int s) {
                this.position = p;
                this.steps = s;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
