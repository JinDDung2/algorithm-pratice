package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfOccurrencesOfSubstring_1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int[] cnt = new int[26];
        Map<String, Integer> map = new HashMap<>();
        int l = 0, r = 0, max = 0, result = 0;

        while (r < s.length()) {
            char c = s.charAt(r++);
            if (cnt[c - 'a'] == 0) {
                max++;
            }
            cnt[c - 'a']++;

            if (r - l < minSize) continue;
            if (r - l > minSize) {
                char t = s.charAt(l);
                cnt[t - 'a']--;
                if (cnt[t - 'a'] == 0) {
                    max--;
                }
                l++;
            }

            if (max <= maxLetters) {
                String str = s.substring(l, r);
                map.put(str, map.getOrDefault(str, 0) + 1);
                result = Math.max(result, map.get(str));
            }
        }

        return result;
    }
}
