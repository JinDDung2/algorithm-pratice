package leetcode;

import java.util.*;

public class Removing_Stars_From_a_String_2390 {
    public String removeStars(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '*' && !deque.isEmpty()) {
                deque.pollLast();
            } else if (Character.isLetter(c)) {
                deque.addLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return !sb.isEmpty() ? sb.toString() : "";
    }
}
