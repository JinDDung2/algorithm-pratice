package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 36. Valid Sudoku
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        // 가로, 세로, 대각선에 같은 숫자 x
        // 전체 행, 전체 열, 작은 사각형
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> col = new HashMap<>();
        Map<Integer, Set<Integer>> cell = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    // 문자열로 된 숫자를 숫자로 바꾸는 방법
                    int num = Character.getNumericValue(c);
                    row.putIfAbsent(i, new HashSet<>());
                    col.putIfAbsent(j, new HashSet<>());
                    // 큰 공간 안에 작은 공간(사각형)의 값 넣기
                    cell.putIfAbsent((i / 3) * 3 + j / 3, new HashSet<>());

                    Set<Integer> set;
                    set = row.get(i);
                    if (set.contains(num))
                        return false;
                    set.add(num);

                    set = col.get(j);
                    if (set.contains(num))
                        return false;
                    set.add(num);

                    set = cell.get((i / 3) * 3 + j / 3);
                    if (set.contains(num))
                        return false;
                    set.add(num);
                }
            }
        }
        return true;
    }
}
