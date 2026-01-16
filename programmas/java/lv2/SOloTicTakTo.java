package programmas.java.lv2;


// [lv2] 혼자서 하는 틱택토
public class SOloTicTakTo {
    String[] board = new String[3];

    public int solution(String[] board) {
        this.board = board;
        int countO = 0;
        int countX = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'O') countO++;
                if (c == 'X') countX++;
            }
        }

        if (!(countO == countX || countO == countX + 1)) return 0;

        boolean winO = isWin('O');
        boolean winX = isWin('X');

        if (winO && winX) return 0;
        if (winO && countO != countX + 1) return 0;
        if (winX && countX != countO) return 0;

        return 1;
    }

    boolean isWin(char c) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c &&
                    board[i].charAt(1) == c &&
                    board[i].charAt(2) == c) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if(board[0].charAt(j) == c &&
                    board[1].charAt(j) == c &&
                    board[2].charAt(j) == c) {
                return true;
            }
        }

        if (board[0].charAt(0) == c &&
                board[1].charAt(1) == c &&
                board[2].charAt(2) == c) {
            return true;
        }

        if (board[0].charAt(2) == c &&
                board[1].charAt(1) == c &&
                board[2].charAt(0) == c) {
            return true;
        }

        return false;
    }
}
