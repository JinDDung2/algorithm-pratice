package BOJ;

import java.io.*;

public class P7682_틱택토 {
    static class Problem {
        /**
         * 1. 9개 문자(입력 한 줄)를 3*3 격자로 만들기
         * 2. 승리 조건 확인 (X승리 or Y 승리)
         *  2-1) 가로, 세로, 대각선 3개 유무 확인
         * 3. 유효한 상태인지 확인
         *  3-1) X 승리 시 X의 갯수 = Y 갯수 + 1
         *  3-2) Y 승리 시 Y의 갯수 = X 갯수
         *  3-3) 둘 다 승리 -> invalid
         *  3-4) 승자 없고 9칸 풀이 아니면 -> invalid
         *  3-5) 만족하는게 없다면 -> invalid
         */
        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            char[][] data = new char[3][3];
            String input;

            while (!(input = br.readLine()).equals("end")) {

                int idx = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        data[i][j] = input.charAt(idx++);
                    }
                }

                bw.write(isValidState(data) ? "valid\n" : "invalid\n");
            }

            br.close();
            bw.flush();
            bw.close();
        }

        boolean isValidState(char[][] data) {
            int xCnt = countTarget(data, 'X');
            int oCnt = countTarget(data, 'O');

            boolean xWin = isWin(data, 'X');
            boolean yWin = isWin(data, 'O');

            if (xCnt < oCnt || xCnt > oCnt + 1) return false;

            if (xWin && yWin) return false;
            if (xWin && xCnt != oCnt + 1) return false;
            if (yWin && oCnt != xCnt) return false;

            // 게임 끝나지 않은 상태
            if (!xWin && !yWin && xCnt + oCnt < 9) return false;

            return true;
        }

        int countTarget(char[][] data, char target) {
            int cnt = 0;

            for (char[] row : data) {
                for (char cell : row) {
                    if (cell == target) cnt++;
                }
            }

            return cnt;
        }

        boolean isWin(char[][] data, char target) {
            // 가로, 세로
            for (int i = 0; i < 3; i++) {
                if (data[i][0] == data[i][1] && data[i][1] == data[i][2] && data[i][2] == target) return true;
                if (data[0][i] == data[1][i] && data[1][i] == data[2][i] && data[2][i] == target) return true;
            }

            // 대각선
            if (data[0][0] == data[1][1] && data[1][1] == data[2][2] && data[2][2] == target) return true;
            if (data[0][2] == data[1][1] && data[1][1] == data[2][0] && data[2][0] == target) return true;

            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
