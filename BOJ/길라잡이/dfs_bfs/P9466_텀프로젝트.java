package BOJ.길라잡이.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9466_텀프로젝트 {

    static class Problem {

        int T, N;
        int[] data;
        boolean[] visited;
        boolean[] finished;
        int count;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            T = Integer.parseInt(br.readLine());

            while (T-- > 0) {
                N = Integer.parseInt(br.readLine());
                data = new int[N + 1];
                visited = new boolean[N + 1];
                finished = new boolean[N + 1];
                count = 0;

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= N; i++) {
                    data[i] = Integer.parseInt(st.nextToken());
                }

                for (int i = 1; i <= N; i++) {
                    if (!finished[i]) dfs(i);
                }

                System.out.println(N - count);
            }
        }

        void dfs(int node) {
            if (!visited[node]) {
                visited[node] = true;
            } else {
                finished[node] = true;
                count++;
            }

            int next = data[node];
            if (!finished[next]) {
                dfs(next);
            }

            visited[node] = false;
            finished[node] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
