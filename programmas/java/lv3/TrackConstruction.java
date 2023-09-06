package programmas.java.lv3;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrackConstruction {
    public int solution(int[][] board) {
        int answer = 0;
        Deque<int[]> que = new ArrayDeque<>();
        // boolean[][] visited = new boolean[board.length][board[0].length];
        board[0][0] = 100;
        int[] temp = { 0, 0 };
        que.add(temp);
        System.out.println(que.peek());

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (que.isEmpty()) {
            int[] nums = que.pollFirst();
            int y = nums[0], x = nums[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length)
                    continue;
                if (board[ny][nx] == 0) {
                    board[ny][nx] = board[y][x] + 100;
                }
            }
        }

        return answer;
    }
}
