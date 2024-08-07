package programmas.java.lv2;

public class N_Queen {

    int answer = 0;
    public int solution(int n) {

        boolean[] cols = new boolean[n];
        boolean[] diags = new boolean[2 * n];
        boolean[] revDiags = new boolean[2 * n];

        backtracking(0, cols, diags, revDiags, n);

        return answer;
    }

    private void backtracking(int row, boolean[] cols, boolean[] diags, boolean[] revDiags, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int idx1 = col - row + n;
            int idx2 = col + row;

            if (cols[col] || diags[idx1] || revDiags[idx2]) continue;

            cols[col] = true; diags[idx1] = true; revDiags[idx2] = true;
            backtracking(row + 1, cols, diags, revDiags, n);
            cols[col] = false; diags[idx1] = false; revDiags[idx2] = false;
        }
    }

}
