package programmas.java.lv2;

// 마법의 엘리베이터
public class MagicElevator {
    public int solution(int storey) {
        // 0층이 최저점
        // 10 으로 나눈 몫 + 나머지
        int answer = 0;
        // 6이상 -> (10-n) + 1
        while (storey > 0) {
            int cur = storey % 10;
            int next = (storey / 10) % 10;
            if (cur > 5) {
                answer += (10 - cur);
                storey += 10;
            } else if (cur == 5) {
                answer += 5;
                storey += next >= 5 ? 10 : 0;
            } else {
                answer += cur;
            }
            
            storey /= 10;
            // System.out.println("s=" + storey + " | answer=" + answer);
        }
        return answer;
    }
}
