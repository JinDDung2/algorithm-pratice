package programmas.java.lv3;

import java.util.*;

public class ReturnToArmy {
  // 최단시간 -> bfs
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 거리 배열 및 BFS 초기화
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        Queue<Integer> que = new LinkedList<>();
        que.add(destination);
        distances[destination] = 0;

        // BFS 수행
        while (!que.isEmpty()) {
            int curr = que.poll();
            for (int next : graph.get(curr)) {
                if (distances[next] == -1) {
                    distances[next] = distances[curr] + 1;
                    que.add(next);
                }
            }
        }

        // 결과 생성
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distances[sources[i]];
        }
        return answer;
    }
}
