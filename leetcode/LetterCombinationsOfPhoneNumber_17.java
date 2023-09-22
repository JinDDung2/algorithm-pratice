package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
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

}
