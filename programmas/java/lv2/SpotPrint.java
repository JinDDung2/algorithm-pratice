package programmas.java.lv2;

public class SpotPrint {
    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            double maxY = Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            answer += (Math.floor(maxY) / k) + 1L;
        }

        return answer;
    }
}
