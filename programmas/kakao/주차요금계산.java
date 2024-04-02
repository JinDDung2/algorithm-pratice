package programmas.kakao;

import java.util.*;

public class 주차요금계산 {
    // 시:분 -> int 분
    // treeMap<번호, List<입차시간,출차시간>> -> 가격 계산 -> result에 넣기

    public int[] solution(int[] fees, String[] records) {

        Map<String, List<Integer>> map = new TreeMap<>();

        for (String r : records) {
            String[] data = r.split(" ");
            map.putIfAbsent(data[1], new ArrayList<>());
            int time = convertMin(data[0]);
            List<Integer> value = map.get(data[1]);
            value.add(time);
        }

        int[] answer = new int[map.size()];

        int idx = 0;
        for (String number : map.keySet()) {
            List<Integer> value = map.get(number);
            int time = 0;
            for (int i = 1; i < value.size(); i += 2) {
                time += (value.get(i) - value.get(i - 1));
            }

            if (value.size() % 2 == 1) {
                time += (1439 - value.get(value.size() - 1));
            }

            int price = time < fees[0] ? fees[1] : fees[1] + ((time - fees[0]) + (fees[2] - 1)) / fees[2] * fees[3];
            // System.out.printf("idx=%d, t=%d\n", idx, (time - fees[0] + fees[2] - 2));

            answer[idx++] = price;
        }

        // System.out.println(map);
        return answer;
    }

    private int convertMin(String time) {
        String[] data = time.split(":");
        return Integer.parseInt(data[0]) * 60 + Integer.parseInt(data[1]);
    }
}
