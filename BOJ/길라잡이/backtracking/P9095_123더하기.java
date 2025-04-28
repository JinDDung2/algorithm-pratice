package BOJ.길라잡이.backtracking;

import java.util.*;

public class P9095_123더하기 {
    static class Problem {
        int cnt;

        void solution() {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while (t-- > 0) {
                cnt = 0;
                int n = sc.nextInt();
                backtracking(0, n);
                System.out.println(cnt);
            }
        }

        void backtracking(int sum, int target) {
            if (sum >= target) {
                if (sum == target) cnt++;
                return;
            }

            backtracking(sum + 1, target);
            backtracking(sum + 2, target);
            backtracking(sum + 3, target);
        }
    }

    public static void main(String[] args) {
        Problem problem = new Problem();
        problem.solution();
    }
}
