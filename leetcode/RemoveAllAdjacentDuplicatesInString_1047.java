package leetcode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.add(c);
                continue;
            }

            stack.pop();
        }

        int len = stack.size();
        for (int i = 0; i < len; i++) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
