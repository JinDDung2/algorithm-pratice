package BOJ;

import java.io.*;
import java.util.*;

// [G1] 17834. 사자와 토끼

public class 사자와토끼_17834 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);

        boolean isBipartite = true;
        long count1 = 0, count2 = 0;

        for (int i = 0; i <= n; i++) {
            if (colors[i] == -1) {
                if (!bfs(graph, colors, i)) {
                    isBipartite = false;
                    break;
                }
            }
        }

//        System.out.println("Arrays.toString(colors) = " + Arrays.toString(colors));

        if (isBipartite) {
            for (int i = 1; i <= n; i++) {
                int color = colors[i];
                if (color == 0) count1++;
                else if (color == 1) count2++;
            }
            System.out.println(count1 * count2 * 2);
        } else {
            System.out.println(0);
        }

        br.readLine();
    }

    private static boolean bfs(List<Integer>[] graph, int[] colors, int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        colors[start] = 0;

        while (!que.isEmpty()) {
            int u = que.poll();

            for (int v : graph[u]) {
                if (colors[v] == -1) {
                    colors[v] = 1 - colors[u];
                    que.add(v);
                } else if (colors[v] == colors[u]) {
                    return false;
                }
            }
        }

        return true;
    }
}
