package programmas.java.lv2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int day = 1;
        int cnt = 0;
        Deque<Integer> p = new LinkedList();
        Deque<Integer> s = new LinkedList();

        for (int i = 0; i < speeds.length; i++) {
            p.add(progresses[i]);
            s.add(speeds[i]);
        }

        while (!p.isEmpty()) {
            if (p.peek() + (s.peek() * day) >= 100) {
                p.poll();
                s.poll();
                cnt++;
            } else {
                if (cnt > 0) {
                    result.add(cnt);
                    cnt = 0;
                }
                day++;
            }
        }
        result.add(cnt);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
