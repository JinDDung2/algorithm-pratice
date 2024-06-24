package coding_test.naver2024_high;

import java.util.*;

public class P2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[][] { { 2423, 10 }, { 3423, 30 }, { 1, 40 }, { 450, 50 }, { 1200, 60 }, { 2781, 100 } },
                new int[] { 2, 1 }))); // [3, 2]
        System.out.println(Arrays.toString(solution(new int[][] { { 10, 50000, 100 }, { 1, 100000, 1100 },
                { 51, 100000, 2100 }, { 90, 100000, 3100 }, { 73, 50000, 4100 } }, new int[] { 10, 4 }))); // [4, 1]
    }

    public static int[] solution(int[][] delays, int[] limits) {

        int max = Integer.MIN_VALUE, server = -1;

        for (int i = 0; i < delays[0].length; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < delays.length; j++) {
                list.add(delays[j][i]);
            }

            Collections.sort(list);

            int l = 0, r = 0;
            while (r < list.size()) {
                int cur = list.get(r++);

                while (list.get(l) * limits[0] <= cur || cur - list.get(l) >= limits[1] * 1000) {
                    l++;
                }

                if (r - l > max) {
                    max = r - l;
                    server = i + 1;
                }
            }
        }
        return new int[] { max, server };
    }

}
