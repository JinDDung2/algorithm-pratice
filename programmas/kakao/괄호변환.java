package programmas.kakao;

import java.util.*;

// 2020 KAKAO BLIND RECRUITMENT 괄호 변환

public class 괄호변환 {
    public String solution(String p) {
        if (p.trim().length() == 0 || isCorrectBracket(p)) {
            return p;
        }

        String answer = makeBalancedBracket(p);
        return answer;
    }

    private String makeBalancedBracket(String str) {
        if (str.length() == 0)
            return "";

        StringBuilder result = new StringBuilder();
        String[] uv = seperateUV(str);
        String u = uv[0], v = uv[1];

        if (isCorrectBracket(u)) {
            result.append(u).append(makeBalancedBracket(v));
        } else {
            StringBuilder temp = new StringBuilder();
            temp.append('(').append(makeBalancedBracket(v)).append(')');
            u = u.substring(1, u.length() - 1);
            for (char c : u.toCharArray()) {
                if (c == '(')
                    temp.append(')');
                else
                    temp.append('(');
            }
            result.append(temp);
        }

        return result.toString();
    }

    private String[] seperateUV(String str) {
        int l = 0, r = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                l++;
            else
                r++;

            if (l == r) {
                String u = str.substring(0, i + 1);
                String v = (i + 1 < str.length() ? str.substring(i + 1) : "");
                return new String[] { u, v };
            }
        }

        return new String[] { "", "" };
    }

    private boolean isCorrectBracket(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                deque.addLast(c);
            } else {
                if (deque.size() == 0)
                    return false;
                else if (deque.peekLast() == '(') {
                    deque.pollLast();
                }
            }
        }

        if (deque.size() > 0)
            return false;

        return true;
    }
}