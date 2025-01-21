package BOJ;

import java.io.*;
import java.util.*;

public class P1697_숨바꼭질 {
    static class Problem {
        int solution() throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // <= 100,000
            int K = Integer.parseInt(st.nextToken()); // <= 100,000

            // 수빈이 위치 > 동생 위치 = 수빈위치 - 동생위치
            if (N > K) return N - K;

            int[] dp = new int[100_001];
            Queue<Integer> que = new LinkedList<>();
            que.add(N);

            while (!que.isEmpty()) {
                int curr = que.poll();
                if (curr == K) return dp[K];

                int[] nextIdxs = new int[]{curr - 1, curr + 1, curr * 2};
                for (int nextIdx : nextIdxs) {
                    if (nextIdx >= 0 && nextIdx <= 100_000 && dp[nextIdx] == 0) {
                        dp[nextIdx] = dp[curr] + 1;
                        que.add(nextIdx);
                    }
                }
            }

            return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
