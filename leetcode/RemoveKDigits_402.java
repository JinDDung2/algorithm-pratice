package leetcode;

import java.util.Stack;

// 402. Remove K Digits
public class RemoveKDigits_402 {
    // num 길이 <= k return 0

    // stack:
    // 비어있으면 추가.
    // 이하 비어있지 않다면, while stack.peek > 비교할 값 ? stack.pop + k--
    // 만약 0을 만난다면? 스택이 비어잇지 않으면 stack.pop
    // 끝까지 돌았는데 k가 남아있다면? 마지막에 k만큼 stack.pop
    // 마지막에 스택에 있는 값을 sb에 넣고 sb.reverse.tostring
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));

        for (int i = 1; i < num.length(); i++) {
            char c = num.charAt(i);

            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);

            if (stack.size() == 1 && c == '0') {
                stack.pop();
            }
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.isEmpty() ? "0" : sb.reverse().toString();
    }
}
