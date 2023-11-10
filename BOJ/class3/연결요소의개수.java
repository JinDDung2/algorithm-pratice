package BOJ.class3;

import java.io.*;
import java.util.*;

// [S2] 11724. 연결 요소의 개수
public class 연결요소의개수 {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        // System.out.println(graph);

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cnt++;
                int size = graph.get(i).size();
                for (int k = 0; k < size; k++) {
                    dfs(graph.get(i).get(k));
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }

    private static void dfs(int idx) {
        if (visited[idx])
            return;

        visited[idx] = true;
        int size = graph.get(idx).size();
        for (int i = 0; i < size; i++) {
            dfs(graph.get(idx).get(i));
        }
    }

}