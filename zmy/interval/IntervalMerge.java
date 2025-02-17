package zmy.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalMerge {

    /**
     * 시간복잡도 -> NlogN
     * 1) 정렬 O(NlogN)
     * 2) 병합 O(N)
     */
    public List<int[]> solution(int[][] data) {
        if (data == null || data.length == 0) return new ArrayList<>();

        Arrays.sort(data, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] curr = data[0];

        for (int i = 1 ; i < data.length; i++) {
            int[] next = data[i];

            if (curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                merged.add(curr);
                curr = next;
            }
        }

        merged.add(curr);

        return merged;
    }

    public static void main(String[] args) {
        IntervalMerge p = new IntervalMerge();
        int[][] intervals = { {1,3}, {2,6}, {8,10}, {15,18} };

        List<int[]> result = p.solution(intervals);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
