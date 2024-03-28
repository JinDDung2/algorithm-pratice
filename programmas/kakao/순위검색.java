package programmas.kakao;

import java.util.*;

public class 순위검색 {

    Map<String, List<Integer>> infos = new HashMap<>();

    public int[] solution(String[] info, String[] query) {

        // query처럼 만들기
        for (String in : info) {
            String[] s = in.split(" ");
            int score = Integer.parseInt(s[4]);
            comb(s, "", 0, score);
        }

        for (List<Integer> list : infos.values()) {
            Collections.sort(list);
        }

        // System.out.println(infos);
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] s = query[i].replaceAll(" and ", "").split(" ");
            String key = s[0];
            int score = Integer.parseInt(s[1]);
            // System.out.printf("key=%s, score=%d\n", key, score);
            if (!infos.containsKey(key)) {
                answer[i] = 0;
                continue;
            }
            List<Integer> scores = infos.get(key);
            int l = 0, r = scores.size() - 1;

            while (l <= r) {
                int m = l + (r - l) / 2;

                if (scores.get(m) < score) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            answer[i] = scores.size() - l;
        }

        return answer;
    }

    private void comb(String[] arr, String str, int depth, int score) {
        if (depth == 4) {
            infos.computeIfAbsent(str, k -> new ArrayList<>()).add(score);
            return;
        }

        comb(arr, str + "-", depth + 1, score);
        comb(arr, str + arr[depth], depth + 1, score);
    }
}
