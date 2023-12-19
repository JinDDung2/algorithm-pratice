package leetcode;

import java.util.*;

// 71. Simplify Path
public class SimplifyPath_71 {
    public String simplifyPathV2(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String str : path.split("/")) {
            if (str.equals(".")) {
                continue;
            } else if (str.equals("..") && !str.isEmpty()) {
                stack.pollLast();
            } else if (!str.equals("")) {
                stack.addLast(str);
            }
        }

        return "/" + String.join("/", stack);
    }

    public String simplifyPathV1(String path) {
        // "/" 으로 나눈다.
        // ".." -> pop();
        // "..", ".", "" conatins ? pass : add()
        // sb.empty ? "/" : sb.append("/").append("stack[idx]")
        List<String> stack = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
        StringBuilder sb = new StringBuilder();
        for (String str : path.split("/")) {
            if (str.equals("..") && !stack.isEmpty()) {
                stack.remove(stack.size() - 1);
            } else if (!set.contains(str)) {
                stack.add(str);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            sb.append("/").append(stack.get(i));
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
}
