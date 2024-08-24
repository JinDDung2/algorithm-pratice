package programmas.java.lv3;

import java.util.Arrays;

// [lv3] 섬 연결하기 미완
public class 섬연결하기 {

    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        // 간선 비용을 오름차순으로 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        // 유니온-파인드 배열 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        return answer;
    }

    // 유니온 함수
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    // 파인드 함수
    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // 경로 압축
    }

}


