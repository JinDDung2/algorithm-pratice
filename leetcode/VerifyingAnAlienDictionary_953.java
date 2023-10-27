package leetcode;

import java.util.HashMap;
import java.util.Map;

// 953. Verifying an Alien Dictionary
public class VerifyingAnAlienDictionary_953 {

    public boolean isAlienSortedV2(String[] words, String order) {

        if (words == null || words.length == 1) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        String word = words[0];

        for (int i = 1; i < words.length; i++) {
            String next = words[i];
            boolean isAllSame = true;
            for (int j = 0; j < Math.min(word.length(), next.length()); j++) {
                char c1 = word.charAt(j);
                char c2 = next.charAt(j);

                if (c1 != c2) {
                    isAllSame = false;
                    if (map.get(c1) > map.get(c2)) {
                        return false;
                    } else {
                        break;
                    }
                }
            }

            if (isAllSame && word.length() > next.length())
                return false;

            word = next;
        }

        return true;
    }

    public boolean isAlienSortedV1(String[] words, String order) {
        if (words == null || words.length == 1) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i), i);
        }

        String word = words[0];

        for (int i = 1; i < words.length; i++) {
            String next = words[i];
            boolean isAllSame = true;
            for (int j = 0; j < Math.min(word.length(), next.length()); j++) {
                char c1 = word.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    isAllSame = false;
                    if (map.get(c1) > map.get(c2)) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
            if (isAllSame && word.length() > next.length())
                return false;

            word = next;
        }

        return true;
    }
}
