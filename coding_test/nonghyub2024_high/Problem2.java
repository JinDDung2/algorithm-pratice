package coding_test.nonghyub2024_high;

import java.util.*;

public class Problem2 {
    // 7m
    public int solution(int[] giftCards, int[] wants) {
        int n = giftCards.length;
        int takePeople = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < giftCards.length; i++) {
            map.put(giftCards[i], map.getOrDefault(giftCards[i], 0) + 1);
        }

        for (int want : wants) {
            if(!map.containsKey(want)) continue;
            int value = map.get(want);
            if (value > 0) {
                takePeople++;
                value--;
                map.put(want, value);
            }
        }

        return n - takePeople;
    }

    public static void main(String[] args) {
        int[] gift1 = {4, 5, 3, 2, 1};
        int[] want1 = {2, 4, 4, 5, 1};
        int[] gift2 = {5, 4, 5, 4, 5};
        int[] want2 = {1, 2, 3, 5, 4};
        Problem2 problem2 = new Problem2();
        System.out.println("result1 = " + problem2.solution(gift1, want1));
        System.out.println("result2 = " + problem2.solution(gift2, want2));
    }
}
