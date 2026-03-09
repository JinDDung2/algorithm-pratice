package leetcode;

import java.util.Stack;

public class DecodeString_394 {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> sbs = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                nums.push(num);
                num = 0;
                sbs.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                int k = nums.pop();
                StringBuilder temp = sb;
                sb = sbs.pop();
                while (k-- > 0) {
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
