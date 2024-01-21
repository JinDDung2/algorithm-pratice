package leetcode;

public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        // 첫 글자 같을 경우에만 탐색 시작
        // dfs : cnt == word.length -> return
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && searchWord(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchWord(char[][] board, String word, boolean[][] visited, int y, int x, int cnt) {
        if (cnt == word.length())
            return true;

        if (x < 0 || y < 0 || y >= board.length || x >= board[0].length)
            return false;
        if (board[y][x] != word.charAt(cnt) || visited[y][x])
            return false;

        visited[y][x] = true;
        if (searchWord(board, word, visited, y + 1, x, cnt + 1) ||
                searchWord(board, word, visited, y, x + 1, cnt + 1) ||
                searchWord(board, word, visited, y - 1, x, cnt + 1) ||
                searchWord(board, word, visited, y, x - 1, cnt + 1)) {
            return true;
        }

        visited[y][x] = false;
        return false;
    }
}
