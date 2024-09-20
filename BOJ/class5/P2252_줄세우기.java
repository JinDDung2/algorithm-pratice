package BOJ.class5;

import java.io.*;
import java.util.*;

// 위상 정렬은 방향성이 있는 그래프(DAG: Directed Acyclic Graph)에서 각 노드(학생)를 선행 조건에 따라 순서대로 나열하는 방식

public class P2252_줄세우기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            inDegree[to]++;
        }

        // que에는 진입차수 = 0만 존재
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!que.isEmpty()) {
            int curr = que.poll();
            result.add(curr);

            for (int next : graph.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    que.add(next);
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for (int num : result) {
            output.append(num).append(" ");
        }
        output.deleteCharAt(output.length() - 1);
        System.out.println(output);

        br.close();
    }
}
