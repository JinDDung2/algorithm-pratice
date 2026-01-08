package programmas.java.lv2;

public class PuzzleGameChallenge {
    public int solution(int[] diffs, int[] times, long limit) {
        // 제한시간 내에 최소한의 레벨로 문제 풀기
        // 파라메트릭 서치 대상: 레벨
        // 해당 레벨로 문제 푼 시간을 limit 과 비교
        // 숙련도 -> 양의 정수
        // 300,000 * 18
        int n = diffs.length;
        int l = 1;
        int r = 100_000;

        while (l < r) {
            int m = l + (r - l) / 2;
            System.out.print(m + " ");
            if (canSolveWithInTime(diffs, times, limit, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    boolean canSolveWithInTime(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;
        long timePrev = 0;

        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int timeCur = times[i];

            if (diff <= level) {
                totalTime += timeCur;
            } else {
                int mistakes = diff - level;
                totalTime += mistakes * (timeCur + timePrev) + timeCur;
            }

            if (totalTime > limit) return false;
            timePrev = timeCur;
        }

        return totalTime <= limit;
    }
}
