package leetcode;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses_1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c == '(') {
                stack.add(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    arr[i] = '0';
                } else {
                    stack.pop();
                }
            }
        }

        for (Integer i : stack) {
            arr[i] = '0';
        }

        return new String(arr).replace("0", "");
    }
}
