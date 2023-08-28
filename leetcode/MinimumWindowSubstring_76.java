package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println("map= " + map);

        int left = 0, right = 0, len = Integer.MAX_VALUE, idx = -1, cnt = t.length();
        // 처음부터 t를 모두 포함하는 인덱스까지 구하기
        // 왼쪽에서부터 t와 상관없은 인덱스 제거
        while (right < s.length()) {
            char c = s.charAt(right++);

            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    cnt--;
                }

                map.put(c, map.get(c) - 1);
            }

            while (cnt == 0) {
                if (right - left < len) {
                    len = right - left;
                    idx = left;
                }

                char tmp = s.charAt(left++);

                if (map.containsKey(tmp)) {
                    if (map.get(tmp) == 0) {
                        cnt++;
                    }

                    map.put(tmp, map.get(tmp) + 1);
                }
            }
        }
        // System.out.printf("idx=%d, left=%d, right=%d, len=%d", idx, left, right,
        // len);
        return idx == -1 ? "" : s.substring(idx, idx + len);
    }
}
