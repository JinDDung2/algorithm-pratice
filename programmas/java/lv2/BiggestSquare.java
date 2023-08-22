package programmas.java.lv2;

public class BiggestSquare 
{
    int[][] dp;
    public int solution(int [][]board)
    {
        if (checkAllZero(board)) return 0;
        dp = new int[board.length+1][board[0].length+1];
        int answer = -1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (board[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    if (dp[i][j] > answer) {
                        answer = dp[i][j];
                    }
                }
            }
        }

        return answer * answer;
    }
    
    public boolean checkAllZero(int [][]board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j< board[0].length; j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }    
}
