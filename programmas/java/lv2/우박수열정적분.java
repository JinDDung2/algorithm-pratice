package programmas.java.lv2;

import java.util.ArrayList;
import java.util.List;

// [lv2] 우박수열 정적분
public class 우박수열정적분 {
    public double[] solution(int k, int[][] ranges) {
        List<Long> sequence = new ArrayList<>();
        long curr = k;

        sequence.add(curr);
        while (curr != 1) {
            if (curr % 2 == 0) curr /= 2;
            else curr = curr * 3 + 1;
            sequence.add(curr);
        }

        int n = sequence.size();
        double[] area = new double[n - 1];
        for (int i = 0; i < n - 1; i++) {
            area[i] = (sequence.get(i) + sequence.get(i + 1)) / 2.0;
        }

        double[] prefix = new double[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + area[i - 1];
        }

        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int s = ranges[i][0];
            int e = (n - 1) + ranges[i][1];

            if (s > e) answer[i] = (double) -1;
            else answer[i] = prefix[e] - prefix[s];
        }

        return answer;
    }
}
