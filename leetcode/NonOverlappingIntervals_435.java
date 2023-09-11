package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[1]));

        int[] temp = { intervals[0][0], intervals[0][1] };
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] <= intervals[i][0]) {
                temp[1] = intervals[i][1];
                continue;
            }
            result++;
            // System.out.println(Arrays.toString(temp));
        }
        return result;
    }
}
