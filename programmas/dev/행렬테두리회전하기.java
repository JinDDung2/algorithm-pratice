package programmas.dev;

// 2021 Dev-Matching:웹 백엔드 개발 행령 테두리 회전하기

public class 행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] data = new int[rows][columns];

        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = num++;
            }
        }

        for (int k = 0; k < queries.length; k++) {
            int[] query = queries[k];
            int sy = query[0] - 1;
            int sx = query[1] - 1;
            int ey = query[2] - 1;
            int ex = query[3] - 1;
            int first = data[sy][sx];
            int minNum = first;

            // top
            for (int i = sy; i < ey; i++) {
                data[i][sx] = data[i + 1][sx];
                minNum = Math.min(minNum, data[i][sx]);
            }

            // left
            for (int i = sx; i < ex; i++) {
                data[ey][i] = data[ey][i + 1];
                minNum = Math.min(minNum, data[ey][i]);
            }

            // down
            for (int i = ey; i > sy; i--) {
                data[i][ex] = data[i - 1][ex];
                minNum = Math.min(minNum, data[i][ex]);
            }

            // right
            for (int i = ex; i > sx + 1; i--) {
                data[sy][i] = data[sy][i - 1];
                minNum = Math.min(minNum, data[sy][i]);
            }

            data[sy][sx + 1] = first;
            answer[k] = minNum;

        }
        return answer;
    }
}
