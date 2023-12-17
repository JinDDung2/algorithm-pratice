package leetcode;

import java.util.*;

public class RomanToInteger_13 {
    // {"char":int}
    // 특정 캐릭터 - 1 -> 앞자리가 뒷자리보다 작으면 rst -= value;
    // 아니면 rst += value;
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int rst = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                rst -= map.get(s.charAt(i));
                continue;
            }
            rst += map.get(s.charAt(i));
        }
        return rst;
    }
}
