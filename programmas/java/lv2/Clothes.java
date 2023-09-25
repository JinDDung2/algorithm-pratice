package programmas.java.lv2;

import java.util.*;

public class Clothes {
    static HashMap<String, Integer> map = new HashMap<>();

    public int solution(String[][] clothes) {
        int answer = 1;

        for (String[] c : clothes) {
            String key = c[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        System.out.println(map);
        for (int num : map.values()) {
            System.out.println(num);
            answer *= (num + 1);
        }

        return answer - 1;
    }
}
