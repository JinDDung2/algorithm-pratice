package leetcode;

import java.util.Arrays;

public class Determine_if_Two_Strings_Are_Close_1657 {
    // if (w1[i] > 0 && w2[i] == 0) || (w1[i] == 0 && w2[i] > 0) -> false
    // 같은 개수가 있어야 알파벳들을 한꺼번에 변경 가능
    public boolean closeStrings(String word1, String word2) {
        int[] w1 = new int[26];
        int[] w2 = new int[26];

        for (char c : word1.toCharArray()) {
            w1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            w2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((w1[i] == 0 && w2[i] > 0) || (w1[i] > 0 && w2[i] == 0)) return false;
        }

        Arrays.sort(w1);
        Arrays.sort(w2);

        for (int i = 0; i < 26; i++) {
            if (w1[i] != w2[i]) return false;
        }

        return true;
    }
}
