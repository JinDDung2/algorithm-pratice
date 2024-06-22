package nhncommerce2023;

import java.util.*;

/*
테스트 1
        입력값
        "caedb", 1
        기댓값
        "eacdb"
        실행 결과
        실행한 결괏값 ""이 기댓값 "eacdb"과 다릅니다.
        테스트 2
        입력값
        "caedb", 2
        기댓값
        "edcab"
        실행 결과
        실행한 결괏값 ""이 기댓값 "edcab"과 다릅니다.
        테스트 3
        입력값
        "eedcab", 3
        기댓값
        "eedcba"
        실행 결과
        실행한 결괏값 ""이 기댓값 "eedcba"과 다릅니다.
        테스트 4
        입력값
        "cba", 1
        기댓값
        "cba"
        실행 결과
        실행한 결괏값 ""이 기댓값 "cba"과 다릅니다.
        테스트 5
        입력값
        "bacdd", 2
        기댓값
        "ddcba"
        실행 결과
        실행한 결괏값 ""이 기댓값 "ddcba"과 다릅니다.
        */
public class Test2 {
    static int idx = 0;

    public String solution(String s, int k) {
        String answer = "";
        char[] str = s.toCharArray();
        char[] priority = Arrays.copyOf(str, str.length);
        Arrays.sort(priority);
        boolean[] visited = new boolean[str.length];

        for (int a = 0; a < k; a++) {
            if (isReverseSortDict(str, priority))
                break;
            swap(str, priority, visited);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            sb.append(c);
        }

        return String.valueOf(sb);
    }

    private boolean isReverseSortDict(char[] str, char[] priority) {
        for (int i = 0; i < str.length; i++) {
            if (str[i] != priority[str.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private void swap(char[] str, char[] priority, boolean[] visited) {
        if (idx >= str.length)
            return;
        int rightIdx = str.length - 1;
        while (idx < rightIdx) {
            if (priority[rightIdx] > str[idx]
                    && !visited[rightIdx]) {
                char temp = str[idx];
                int chagneIdx = findIdx(str, priority[rightIdx]);
                str[idx] = str[chagneIdx];
                str[chagneIdx] = temp;
                visited[rightIdx] = true;
                idx++;
                break;
            } else
                rightIdx--;
        }

    }

    private int findIdx(char[] str, char target) {
        int idx = str.length - 1;
        while (idx >= 0) {
            if (str[idx] == target)
                break;
            idx--;
        }
        return idx;
    }
}
