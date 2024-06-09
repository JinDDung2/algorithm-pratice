package leetcode;

import java.util.ArrayList;
import java.util.List;

public class N_QUEENS_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                row[j] = '.';
            }
            curr.add(new String(row));
        }
        boolean[] cols = new boolean[n];
        boolean[] diags = new boolean[n * 2 - 1];
        boolean[] reverseDiags = new boolean[n * 2 - 1];

        // row, cols, diags, reversDiags, n, curr, result
        backtracking(0, n, cols, diags, reverseDiags, curr, result);
        return result;
    }

    private void backtracking(int row, int n, boolean[] cols, boolean[] diags, boolean[] reverseDiags, List<String> curr, List<List<String>> result) {
        if (row == n) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!cols[col] && !diags[col + row] && !reverseDiags[col - row + n - 1]) {
                cols[col] = true; diags[col + row] = true; reverseDiags[col - row + n - 1] = true;
                char[] rArr = curr.get(row).toCharArray();
                rArr[col] = 'Q';
                curr.set(row, new String(rArr));
                backtracking(row + 1, n, cols, diags, reverseDiags, curr, result);
                cols[col] = false; diags[col + row] = false; reverseDiags[col - row + n - 1] = false;
                rArr[col] = '.';
                curr.set(row, new String(rArr));
            }
        }
    }
}
