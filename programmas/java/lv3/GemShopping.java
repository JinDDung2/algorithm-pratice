package programmas.java.lv3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GemShopping {
    public int[] solution(String[] gems) {

        // 진열대의 특정 범위의 보석을 구매
        // 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간
        // set -> 보석 종류
        // NlogN -> 이진탐색 + for문
        // map -> rigth+=1 left-=1 if left > 0
        // 담고 있는 map의 길이가 짧은걸로 게속 재할당
        int[] answer = new int[2];
        int kind = new HashSet<>(Arrays.asList(gems)).size();
        int len = Integer.MAX_VALUE, start = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            if (map.size() == kind && len > (end - start)) {
                len = (end - start);
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }

        return answer;
    }

}
