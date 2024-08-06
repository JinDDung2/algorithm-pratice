package programmas.java.lv2;

import java.util.*;

// [lv2] 소수 찾기

public class 소수찾기 {
    // 순열 -> 백트래킹 -> set에 담기
    // 소수 찾기 메서드

    public int solution(String numbers) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        backtracking(numbers, new StringBuilder(), set, new boolean[numbers.length()]);

        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private void backtracking(String numbers, StringBuilder curr, Set<Integer> numbersSet, boolean[] visited) {
        if (curr.length() > 0) {
            numbersSet.add(Integer.valueOf(curr.toString()));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                curr.append(numbers.charAt(i));
                backtracking(numbers, curr, numbersSet, visited);
                curr.deleteCharAt(curr.length() - 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {

        if (num < 2) return false;

        for (int i = 2; i < (int) Math.sqrt(num) + 1; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
