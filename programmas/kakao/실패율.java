package programmas.kakao;

import java.util.*;

// 2019 KAKAO BLIND RECRUITMENT 실패율

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] fails = new int[N + 1];
        int[] total = new int[N + 1];
        double[] statics = new double[N];

        for (int i = 0; i < stages.length; i++) {
            int idx = stages[i];

            if (idx > N)
                continue;
            fails[idx]++;
        }

        total[1] = stages.length;
        for (int i = 2; i <= N; i++) {
            total[i] = total[i - 1] - fails[i - 1];
        }

        for (int i = 1; i <= N; i++) {
            if (total[i] == 0)
                continue;
            statics[i - 1] = (double) fails[i] / total[i];
        }

        // System.out.println(Arrays.toString(fails));
        // System.out.println(Arrays.toString(total));
        // System.out.println(Arrays.toString(statics));

        Integer[] answer = new Integer[N];
        for (int i = 0; i < N; i++) {
            answer[i] = i + 1;
        }

        Arrays.sort(answer, (idx1, idx2) -> Double.compare(statics[idx2 - 1], statics[idx1 - 1]));

        return Arrays.stream(answer)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
