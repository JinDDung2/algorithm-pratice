package BOJ.길라잡이.backtracking;

import java.util.*;

public class P9663_N_Queen {
    static class Problem {

        int N;
        int cnt = 0;

        void solution() {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();

            boolean[] cols = new boolean[N];
            boolean[] diags = new boolean[2 * N];
            boolean[] revDiags = new boolean[2 * N];

            backtracking(0, cols, diags, revDiags);

            System.out.println(cnt);
        }

        void backtracking(int row, boolean[] cols, boolean[] diags, boolean[] revDiags) {
            if (row == N) cnt++;

            for (int col = 0; col < N; col++) {
                int idx1 = col + row;
                int idx2 = col - row + N;

                if (cols[col] || diags[idx1] || revDiags[idx2]) continue;

                cols[col] = true; diags[idx1] = true; revDiags[idx2] = true;
                backtracking(row + 1, cols, diags, revDiags);
                cols[col] = false; diags[idx1] = false; revDiags[idx2] = false;
            }
        }
    }

    public static void main(String[] args) {
        Problem problem = new Problem();
        problem.solution();
    }
}
