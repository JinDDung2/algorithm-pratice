package programmas.kakao;

import java.util.Arrays;

public class 테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) return b[0] - a[0];
            return a[col - 1] - b[col - 1];
        });

        for (int i = row_begin - 1; i < row_end; i++) {
            int Si = 0;
            for (int n : data[i]) {
                Si += n % (i + 1);
            }
            answer ^= Si;
        }

        return answer;
    }
}
