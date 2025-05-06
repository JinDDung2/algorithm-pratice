package BOJ.길라잡이.dp;

import java.util.*;

public class P11726_2xN타일링 {

    static class Problem {

        int N;
        int[] dp;

        void solution() {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            if (N <= 2) {
                System.out.println(N);
                return;
            }

            dp = new int[N + 1];
            dp[1] = 1; dp[2] = 2;

            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }

            System.out.println(dp[N]);
        }

    }

    public static void main(String[] args) {
        Problem problem = new Problem();
        problem.solution();
    }
}
