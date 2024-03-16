package programmas.dev;

import java.util.*;

// 2021 Dev-Matching:웹 백엔드 개발 로또의 최고 순위와 최저 순위

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correct = 0;
        int zero = 0;
        int[] rank = new int[] { 6, 6, 5, 4, 3, 2, 1 };

        for (int my : lottos) {
            if (my == 0) {
                zero++;
                continue;
            }
            for (int win : win_nums) {
                if (my == win) {
                    correct++;
                }
            }
        }

        return new int[] { rank[correct + zero], rank[correct] };
    }
}
