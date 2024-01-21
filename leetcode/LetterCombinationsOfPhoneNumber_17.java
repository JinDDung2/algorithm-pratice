package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 17. Letter Combinations of a Phone Number
public class LetterCombinationsOfPhoneNumber_17 {
    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        find(result, digits, 0, "");

        return result;
    }

    private void find(List<String> result, String digits, int idx, String word) {
        if (idx == digits.length()) {
            result.add(word);
            return;
        }

        char[] arr = map.get(digits.charAt(idx)).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            find(result, digits, idx + 1, word + arr[i]);
        }
    }

    public List<String> letterCombinationsV2(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        backtrack(0, new StringBuilder(), result, digits, letters);
        return result;
    }

    private void backtrack(int idx, StringBuilder sb, List<String> result, String digits, String[] letters) {
        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int num = digits.charAt(idx) - '0';
        String str = letters[num];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtrack(idx + 1, sb, result, digits, letters);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
