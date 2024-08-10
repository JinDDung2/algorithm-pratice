package BOJ;

import java.util.*;
import java.io.*;

// [G2] 1135. 뉴스 전하기

public class 뉴스전하기_1135 {
    // 트리 구조 -> dfs 탐색 -> 최대 시간 계산
    // List<Integer>[]: 각 인덱스
    static List<Integer>[] children;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                children[parent].add(i);
            }
        }

        System.out.println(dfs(0));
        br.close();
    }

    private static int dfs(int node) {
        if (children[node].isEmpty()) {
            return 0;
        }

        List<Integer> times = new ArrayList<>();

        for (int child : children[node]) {
            times.add(dfs(child));
        }

        times.sort(Collections.reverseOrder());

        int maxTime = 0;
        for (int i = 0; i < times.size(); i++) {
            maxTime = Math.max(maxTime, times.get(i) + i + 1);
        }

        return maxTime;
    }
}
