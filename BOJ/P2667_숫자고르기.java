package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P2667_숫자고르기 {
    /**
     * 숫자 사이의 싸이클을 이루는 집합을 찾자.
     * 즉, 선택한 숫자들을 이용해 다시 처음으로 돌아올 수 있는 경우들을 찾는 것
     * 많은 숫자를 포함한 싸이클(집합)을 찾는 것이 목적
     * 사이클 찾는 방법 -> dfs
     * N = 100 -> O(N^2) = 10,000
     */
    static class Problem {

        int N;
        int[] arr;
        boolean[] visited;
        List<Integer> cycles = new ArrayList<>();

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.fill(visited, false);
            for (int i = 1; i <= N; i++) {
                visited[i] = true;
                dfs(i, i);
                visited[i] = false;
            }

            Collections.sort(cycles);
            bw.write(cycles.size() + "\n");
            for (int num : cycles) {
                bw.write(num+ "\n");
            }
            bw.flush();
            bw.close();
            br.close();
        }

        void dfs(int start, int target) {
            if (!visited[arr[start]]) {
                visited[arr[start]] = true;
                dfs(arr[start], target);
                visited[arr[start]] = false;
            }

            if (arr[start] == target) cycles.add(target);
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
