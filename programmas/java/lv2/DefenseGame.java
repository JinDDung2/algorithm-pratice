package programmas.java.lv2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class DefenseGame {
    public int solution(int n, int k, int[] enemy) {
        // 일단 빼. 그리고 부족할 때 큰 값을 롤백시켜주는 방식
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            if (n < enemy[i] && k == 0) {
                break;
            }
            pq.offer(enemy[i]);

            if (n < enemy[i]) {
                n += pq.poll();
                k--;
            }

            n -= enemy[i];
            answer++;
        }
        return answer;
    }
}
