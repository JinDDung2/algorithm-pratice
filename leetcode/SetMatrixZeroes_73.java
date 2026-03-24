package leetcode;

// 73. Set Matrix Zeroes
public class SetMatrixZeroes_73 {
    public void setZeroes(int[][] matrix) {

        boolean firstRow = false;
        boolean firstCol = false;

        int n = matrix.length;
        int m = matrix[0].length;

        // first column check
        for (int r = 0; r < n; r++) {
            if (matrix[r][0] == 0) {
                firstCol = true;
                break;
            }
        }

        // first row check
        for (int c = 0; c < m; c++) {
            if (matrix[0][c] == 0) {
                firstRow = true;
                break;
            }
        }

        // mark
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // update
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (firstRow) {
            for (int c = 0; c < m; c++) {
                matrix[0][c] = 0;
            }
        }

        if (firstCol) {
            for (int r = 0; r < n; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}
