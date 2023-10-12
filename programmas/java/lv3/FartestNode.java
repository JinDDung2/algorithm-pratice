package programmas.java.lv3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FartestNode {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] d = new int[n + 1];
        d[1] = 1;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int dest : graph.get(node)) {
                if (d[dest] == 0) {
                    d[dest] = d[node] + 1;
                    q.add(dest);
                }
            }
        }

        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, d[i]);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] == maxDistance) {
                count++;
            }
        }

        return count;
    }
}
