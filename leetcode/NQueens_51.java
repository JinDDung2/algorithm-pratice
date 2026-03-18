package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 51. N-Queens
public class NQueens_51 {
    // Q -> 해당 row, col, diag에 다른 Q를 둘 수 없음
    // diag: 정방향, 역방향 모두 활용해야 함
    // 모든 경우의 수 탐색, 탐색 중 조건에 부합하지 않으면 이전탐색했던곳으로-> backtracking

    // row를 하나씩 증가하면서 -> dfs(row)?
    // 해당 어느 col에 놓을 수 있는가?
    // 재귀 탐색해야 할 것
    // 1. 같은 row에 퀸이 있는가
    // 2. 좌상향-우하향 대각선에 퀸이 있는가?
    // 2-1. 우하향 대각선: row = col, but 음수 가능성 존재: row - col + (n - 1)
    // 2-2. 우상향 대각선: row + col
    // boolean[]으로 cols, diag1, diag2 활용하면 확인 가능

    int[] queens; // queens[row] = col
    List<List<String>> result = new ArrayList<>();
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.cols = new boolean[n];
        this.diag1 = new boolean[2 * n - 1];
        this.diag2 = new boolean[2 * n - 1];
        this.queens = new int[n];

        dfs(0);
        return result;
    }

    void dfs(int row) {
        // 모든 행에 퀸을 다 넣으면 return
        if (row == n) {
            result.add(buildBoard()); // 보드 만들어서 넣기
            return;
        }

        // col 반복하며 백트래킹
        for (int col = 0; col < n; col++) {
            int d1 = row - col + (n - 1);
            int d2 = row + col;

            // 퀸을 놓을 수 없으면 pass
            if (cols[col] || diag1[d1] || diag2[d2]) continue;
            // 퀸 놓기
            queens[row] = col;
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            dfs(row + 1);
            // 원상복구(백트래킹을 위해)
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    List<String> buildBoard() {
        List<String> board = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            char[] line = new char[n];
            Arrays.fill(line, '.');
            line[queens[row]] = 'Q';
            board.add(new String(line));
        }

        return board;
    }
}
