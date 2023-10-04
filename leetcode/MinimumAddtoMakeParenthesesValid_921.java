package leetcode;

import java.util.ArrayList;

public class MinimumAddtoMakeParenthesesValid_921 {

    public int minAddToMakeValidV2(String s) {
        int open = 0, close = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                open++;
            if (c == ')') {
                if (open > 0)
                    open--;
                else
                    close++;
            }
        }

        return open + close;
    }

    public int minAddToMakeValid(String s) {
        char[] parentheses = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        int result = 0;

        for (char p : parentheses) {
            if (p == '(') {
                list.add(p);
            }

            if (p == ')') {
                if (list.contains('(')) {
                    list.remove(list.size() - 1);
                } else {
                    result++;
                }
            }
        }

        result += list.size();

        return result;
    }
}
