package BOJ.길라잡이.dp;

import java.util.Scanner;

public class P11727_2xN타일링2 {

    static class Problem {

        int N;
        int[] dp;

        void solution() {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            if (N == 1) {
                System.out.println(1);
                return;
            } else if (N == 2){
                System.out.println(3);
                return;
            }

            dp = new int[N + 1];
            dp[1] = 1; dp[2] = 3;

            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
            }

            System.out.println(dp[N]);
        }

    }

    public static void main(String[] args) {
        Problem problem = new Problem();
        problem.solution();
    }
}
