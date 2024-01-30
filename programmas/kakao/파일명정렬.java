package programmas.kakao;

import java.util.*;

// [3차] 파일명 정렬

public class 파일명정렬 {
    // 정규표현식?
    // 문자열 비교 기준
    // 1. HEAD: 사전순, 대소문자 상관x -> 정렬 + lower()
    // 2. NUMBER: 숫자가 큰 순 -> 정렬
    // 3. TAIL: 1번 2번이 같으면 입력 순으로 -> 고려 x
    public String[] solution(String[] files) {
        int n = files.length;

        String[][] data = new String[n][];

        for (int i = 0; i < n; i++) {
            data[i] = splitFileName(files[i]);
        }

        Arrays.sort(data, Comparator.comparing((String[] x) -> x[0].toLowerCase())
                .thenComparingInt(x -> Integer.parseInt(x[1])));

        // for (String[] d : data) {
        // System.out.println(Arrays.toString(d));
        // }

        return Arrays.stream(data)
                .map(arr -> String.join("", arr))
                .toArray(String[]::new);
    }

    private String[] splitFileName(String file) {
        String[] strArr = new String[3];
        strArr[0] = "";
        strArr[1] = "";
        strArr[2] = "";

        // 파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.
        int idx = 0;
        int n = file.length();

        for (int i = 0; i < n; i++) {
            char c = file.charAt(i);
            if (idx == 0 && !Character.isDigit(c)) {
                strArr[idx] += c;
                continue;
            }

            if (idx == 0 && Character.isDigit(c)) {
                idx++;
            }

            if (idx == 1 && Character.isDigit(c)) {
                strArr[idx] += c;
                continue;
            }

            if (idx == 1 && !Character.isDigit(c)) {
                idx++;
            }

            strArr[idx] += c;
        }

        return strArr;
    }
}
