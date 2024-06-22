package programmas.kakao;

import java.util.ArrayDeque;
import java.util.Deque;

// 2022 KAKAO TECH INTERNSHIP 두 큐 합 같게 만들기

public class 두큐합같게만들기 {
    final int MAX_CNT = 300_000 * 2;

    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        Deque<Integer> que1 = new ArrayDeque<>();
        Deque<Integer> que2 = new ArrayDeque<>();

        for (int num : queue1) {
            sum1 += num;
            que1.addLast(num);
        }

        for (int num : queue2) {
            sum2 += num;
            que2.addLast(num);
        }

        int answer = 0;
        while (sum1 != sum2) {
            if (answer >= MAX_CNT)
                break;
            int num;
            if (sum1 > sum2) {
                num = que1.removeFirst();
                sum1 -= num;
                que2.addLast(num);
                sum2 += num;
            } else {
                num = que2.removeFirst();
                sum2 -= num;
                que1.addLast(num);
                sum1 += num;
            }
            answer++;
        }

        return answer >= MAX_CNT ? -1 : answer;
    }
}
