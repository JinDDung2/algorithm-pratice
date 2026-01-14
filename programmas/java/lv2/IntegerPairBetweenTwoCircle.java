package programmas.java.lv2;

public class IntegerPairBetweenTwoCircle {
    public long solution(int r1, int r2) {
        // 1사분면 * 4
        long answer = 0L;

        long r1Sq = (long) r1 * r1;
        long r2Sq = (long) r2 * r2;

        // x축 1부터 r2까지 반복하며 각 라인별 y격자점 개수를 구함
        for (long x = 1; x <= r2; x++) {
            long xSq = x * x;

            // 큰 원 기준 최대 y값
            long yMax = (long) Math.floor(Math.sqrt(r2Sq - xSq));

            // 작은 원 기준 y 최소
            long yMin = 0L;
            long diff = r1Sq - xSq;
            if (diff <= 0) {
                yMin = 0;
            } else {
                yMin = (long) Math.ceil(Math.sqrt(diff));
            }

            if (yMax >= yMin) {
                answer += (yMax - yMin + 1);
            }

        }

        return answer * 4;
    }
}
