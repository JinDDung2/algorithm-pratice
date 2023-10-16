package programmas.java.lv2;

import java.util.Arrays;

public class TableHashFunction {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });

        for (int i = row_begin - 1; i < row_end; i++) {
            int Si = 0;
            for (int j = 0; j < data[i].length; j++) {
                Si += data[i][j] % (i + 1);
            }
            answer ^= Si;
        }

        return answer;
    }
}
