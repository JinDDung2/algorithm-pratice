package coding_test.naver2024_high;

import java.util.*;
import java.util.Map.Entry;

public class P1 {
    public static int[] solution2(int[] emotions, int[] orders) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < emotions.length; i++) {
            map.put(i + 1, new ArrayList<>());
            map.get(i + 1).add(0);
        }

        for (int i = 0; i < orders.length; i++) {
            map.get(orders[i]).add(i + 1);
        }

        int[] deadDay = new int[emotions.length];
        int maxDay = orders.length;
        Arrays.fill(deadDay, -1);
        for (int i = 0; i < emotions.length; i++) {
            int limit = emotions[i];
            List<Integer> values = map.get(i + 1);
            for (int j = 1; j < values.size(); j++) {
                if (values.get(j) - values.get(j - 1) - 1 >= limit) {
                    deadDay[i] = values.get(j - 1) + limit;
                    break;
                }
            }

            if (deadDay[i] == -1 && maxDay - values.get(values.size() - 1) >= limit) {
                deadDay[i] = values.get(values.size() - 1) + limit;
            }
        }

        Map<Integer, Integer> flowersDeadDay = new HashMap<>();
        for (int d : deadDay) {
            if (d != -1) {
                flowersDeadDay.put(d, flowersDeadDay.getOrDefault(d, 0) + 1);
            }
        }
        int[] result = new int[orders.length];
        result[0] = orders.length;
        int minus = 0;
        for (int i = 0; i < orders.length; i++) {
            int num = flowersDeadDay.getOrDefault(i + 1, 0);
            minus += num;
            result[i] = emotions.length - minus;
        }

        return result;
    }

    public static int[] solution(int[] emotions, int[] orders) {
        Map<Integer, int[]> map = new HashMap<>();
        int[] result = new int[orders.length];

        for (int i = 0; i < emotions.length; i++) {
            int e = emotions[i];
            map.put(i + 1, new int[] { e, e });
        }

        int i = 0;
        for (int o : orders) {
            Set<Integer> candidates = new HashSet<>();
            for (Entry<Integer, int[]> e : map.entrySet()) {
                e.getValue()[0]--;

                if (e.getValue()[0] == 0 && e.getKey() != o) {
                    candidates.add(e.getKey());
                }
            }

            for (int key : candidates) {
                map.remove(key);
            }

            if (map.containsKey(o)) {
                int[] v = map.get(o);
                v[0] = v[1];
            }

            result[i++] = map.size();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] emo = new int[300_000];
        int[] orders = new int[300_000];
        for (int i = 0; i < 300_000; i++) {
            emo[i] = 300_000;
            orders[i] = 300_000;
        }
        long start = System.currentTimeMillis();
        // System.out.println(solution(emo, orders));
        System.out.println(solution2(emo, orders));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
        // [4, 2, 2, 2, 2, 1]
        // System.out.println(Arrays.toString(solution2(new int[] { 2, 3, 1, 2 }, new
        // int[] { 3, 1, 2, 1, 4, 1 })));
        // System.out.println(Arrays.toString(solution(new int[] { 2, 3, 1, 2 }, new
        // int[] { 3, 1, 2, 1, 4, 1 })));
        // [3, 3, 3, 3, 3]
        System.out.println(Arrays.toString(solution2(new int[] { 5, 5, 5 }, new int[] { 1, 2, 1, 2, 3 })));
        // // [3, 3, 3, 3, 2]
        System.out.println(Arrays.toString(solution2(new int[] { 5, 5, 5 }, new int[] { 1, 2, 1, 2, 1 })));
        // // [5, 4, 2, 1, 0, 0, 0]
        System.out.println(Arrays.toString(solution2(new int[] { 2, 1, 3, 4, 3 }, new int[] { 2, 2, 2, 2, 5, 5, 5 })));
    }
}
