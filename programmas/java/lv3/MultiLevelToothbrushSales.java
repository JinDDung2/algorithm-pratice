package programmas.java.lv3;

import java.util.HashMap;
import java.util.Map;

// 1트 실패
public class MultiLevelToothbrushSales {
    private final int price = 100;
    private Map<String, Integer> total = new HashMap<>();
    private Map<String, String> ref = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        // {자신: 자신을 추천한 사람}
        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-"))
                continue;
            ref.put(enroll[i], referral[i]);
        }

        // {seller:amount}
        for (int i = 0; i < seller.length; i++) {
            int plus = amount[i] * price;
            int mine = (int) (plus * 0.9);
            int sharedPlus = plus - mine;
            // 자기가 90%
            total.put(seller[i], total.getOrDefault(seller[i], 0) + mine);
            // 자기 위의 10%;
            distributePlus(sharedPlus, seller[i], total, ref);
            // System.out.printf("price=%d, total=%s\n", plus, total);
        }

        // total에 있는 결과 값 넣기
        for (int i = 0; i < enroll.length; i++) {
            String person = enroll[i];
            if (total.containsKey(person)) {
                answer[i] = total.get(person);
            }
        }
        return answer;
    }

    private void distributePlus(int plus, String seller, Map<String, Integer> total, Map<String, String> ref) {
        if (ref.containsKey(seller)) {
            String sharedPerson = ref.get(seller);
            int mine = (int) Math.round(plus * 0.9);
            int sharedPlus = plus - mine;
            total.put(sharedPerson, total.getOrDefault(sharedPerson, 0) + mine);
            distributePlus(sharedPlus, sharedPerson, total, ref);
        }
    }
}
