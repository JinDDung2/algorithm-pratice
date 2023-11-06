package BOJ.class3;

import java.io.*;
import java.util.*;

// [S1] 1697. 숨바꼭질
public class 숨바꼭질 {
    private static int N;
    private static int K;
    private static int[] dp;
    private static boolean[] visited;
    private static Queue<Integer> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1];
        visited = new boolean[K + 1];
        que = new LinkedList<>();
        dp[N] = 1;
        que.add(N);

        while (true) {
            int idx = que.poll();
            if (idx == K) {
                System.out.println(dp[K]);
                break;
            }

            int[] idxs = new int[] { idx - 1, idx + 1, idx * 2 };
            for (int next : idxs) {
                if (next < 0 || next >= K + 1 || visited[next])
                    continue;
                que.add(next);
                visited[next] = true;
                dp[next] = dp[idx] + 1;
            }
        }
    }
}
