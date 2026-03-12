package leetcode;

import java.util.Arrays;

// 1347. Minimum Number of Steps to Make Two Strings Anagram
public class MinimumNumberOfStepsToMakeTwoStringsAnagram_1347 {
    public int minSteps(String s, String t) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int c1 = s.charAt(i);
            int c2 = t.charAt(i);

            arr[c1 - 'a']++;
            arr[c2 - 'a']--;
        }

        int result = 0;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) result += arr[i];
        }

        return result;
    }
}
