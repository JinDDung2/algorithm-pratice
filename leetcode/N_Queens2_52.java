package leetcode;

// 52. N-Queens II
public class N_Queens2_52 {
    int result = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n]; // "행"
        boolean[] diag = new boolean[2 * n]; // "\" 대각선
        boolean[] revDiag = new boolean[2 * n]; // "/" 대각선
        backtracking(0, cols, diag, revDiag, n);

        return result;
    }

    private void backtracking(int row, boolean[] cols, boolean[] diag, boolean[] revDiag, int n) {
        if (row == n)
            result++;

        for (int col = 0; col < n; col++) {
            int i1 = col - row + n;
            int i2 = col + row;

            if (cols[col] || diag[i1] || revDiag[i2])
                continue;

            cols[col] = true;
            diag[i1] = true;
            revDiag[i2] = true;
            backtracking(row + 1, cols, diag, revDiag, n);
            cols[col] = false;
            diag[i1] = false;
            revDiag[i2] = false;
        }
    }
}
