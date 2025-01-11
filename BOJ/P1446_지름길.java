package BOJ;

import java.io.*;
import java.util.*;

public class P1446_지름길 {

    static class Problem {

        static class ShortCut {
            int start;
            int end;
            int distance;

            public ShortCut(int s, int e, int d) {
                this.start = s;
                this.end = e;
                this.distance = d;
            }

            @Override
            public String toString() {
                return String.format("{s=%d, e=%d, d=%d}", start, end, distance);
            }
        }

        // DP
        int solution() throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // <= 12
            int D = Integer.parseInt(st.nextToken()); // <= 10_000

            List<ShortCut> shorCuts = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                // 유효한 지름길만 추가
                if (e <= D && e - s > d) {
                    shorCuts.add(new ShortCut(s, e, d));
                }
            }

            int[] dp = new int[D + 1];
            Arrays.fill(dp, D + 1);
            dp[0] = 0;

            for (int i = 0; i <= D; i++) {
                dp[i] = (i == 0 ? dp[i] = 0 : Math.min(dp[i], dp[i - 1] + 1));
                for (ShortCut shortCut : shorCuts) {
                    if (shortCut.start == i) { // 현재 위치에서 지름길 사용 가능한지
                        dp[shortCut.end] = Math.min(dp[shortCut.end], dp[shortCut.start] + shortCut.distance);
                    }
                }
            }

            return dp[D];
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
