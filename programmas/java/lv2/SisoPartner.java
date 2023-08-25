package programmas.java.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// test 2
// test 1
public class SisoPartner {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Long> map = new HashMap<>();
        for (int w : weights) {
            double a = w * 1.0;
            double b = w * 2.0 / 3;
            double c = w * 1.0 / 2;
            double d = w * 3.0 / 4;

            if (map.containsKey(a))
                answer += map.get(a);
            if (map.containsKey(b))
                answer += map.get(b);
            if (map.containsKey(c))
                answer += map.get(c);
            if (map.containsKey(d))
                answer += map.get(d);

            map.put((w * 1.0), map.getOrDefault(w * 1.0, 0L) + 1L);
        }
        return answer;
    }
}
