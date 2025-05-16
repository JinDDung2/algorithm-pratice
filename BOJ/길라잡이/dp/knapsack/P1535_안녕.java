package BOJ.길라잡이.dp.knapsack;

import java.io.*;
import java.util.*;

public class P1535_안녕 {

    static class Problem {

        int N;
        int[] hp;
        int[] happiness;
        int[][] dp;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            hp = new int[N];
            happiness = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                hp[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                happiness[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N][101];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            int result = solve(0, 100);

            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            br.close();
        }

        int solve(int index, int restHp) {
            if (index == N) return 0;

            if (dp[index][restHp] != -1) return dp[index][restHp];

            // 선택하지 않고 패스
            int answer = solve(index + 1, restHp);

            if (restHp - hp[index] > 0) {
                answer = Math.max(answer, solve(index + 1, restHp - hp[index]) + happiness[index]);
            }

            return dp[index][restHp] = answer;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
