package programmas.kakao;

import java.util.*;

// 2018 KAKAO BLIND RECRUITMENT [3차] 압축

public class 압축 {
    // 알파벳 담는 공간: map<String, Integer>
    // w -> 탐색 길이
    // 사전에 등록되어 있다?
    // 1. 해당 색인 출력
    // 2. 다음 탐색 길이만큼 사전에 등록 substring(idx, plusIdx)
    // 2-1) 다음 글자를 추가한 것이 사전에 있으면 길이를 늘린다
    // 2-2) 다음 글자를 추가한 것이 사전에 없다면 등록한다.
    public int[] solution(String msg) {
        int n = msg.length();
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> dict = new HashMap<>();

        for (int i = 1; i <= 26; i++) {
            dict.put(String.valueOf((char) (i + 64)), i);
        }

        // System.out.println(dict);
        int idx = 0;
        while (true) {
            int plusIdx = idx;

            while (plusIdx < n && dict.containsKey(msg.substring(idx, plusIdx + 1))) {
                plusIdx++;
            }

            if (plusIdx == n)
                break;

            answer.add(dict.get(msg.substring(idx, plusIdx)));
            dict.put(msg.substring(idx, plusIdx + 1), dict.size() + 1);

            idx = plusIdx;
        }

        answer.add(dict.get(msg.substring(idx, n)));

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
