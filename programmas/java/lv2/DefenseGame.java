package programmas.java.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DefenseGame {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Map<Integer, Integer> map = getBigNum(enemy, k);

        for (int e : enemy) {
            if (k > 0 && map.containsKey(e) && map.get(e) > 0) {
                map.put(e, map.get(e) - 1);
                k--;
                answer++;
                continue;
            }

            if (n < e) {
                break;
            }

            n -= e;
            answer++;
        }

        return answer;
    }

    public Map<Integer, Integer> getBigNum(final int[] enemy, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] newArray = Arrays.copyOf(enemy, enemy.length);
        Arrays.sort(newArray);

        for (int i = enemy.length - 1; i > enemy.length - 1 - k; i--) {
            map.put(newArray[i], map.getOrDefault(newArray[i], 0) + 1);
        }

        return map;
    }
}
