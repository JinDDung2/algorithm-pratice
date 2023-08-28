package programmas.java.lv2;

import java.util.Arrays;

public class InterceptionSystem {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[0] - o2[0]);

        int preStart = targets[0][0];
        int preEnd = targets[0][1];

        for (int[] target : targets) {
            if (answer == 0) {
                answer++;
                continue;
            }

            int curStart = target[0];
            int curEnd = target[1];

            if (curStart < preEnd) {
                // 요격 구간이 계속 변경
                // 시작 구간은 더 큰 값을 기준으로 변경
                // 끝 구간은 더 작은 값을 기준으로 변경
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, curEnd);
            } else {
                preStart = curStart;
                preEnd = curEnd;
                answer++;
            }
        }
        return answer;
    }
}
