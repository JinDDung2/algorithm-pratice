package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 3169. Count Days Without Meetings
public class CountDays_3169 {
    // 시작시간 기준 오름차순 정렬
    // 겹치는 구간 병합
    // prev와 cur 비교
    // 겹침 -> 합치기 | 안겹침 -> prev 확정 후 다음으로
    // 실제 회의 있는 시간 빼기 -> days -= (arr[1] - arr[0] + 1) 반복
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        List<int[]> list = new ArrayList<>();
        int[] prev = meetings[0];
        list.add(prev);

        for (int i = 1; i < meetings.length; i++) {
            int[] cur = meetings[i];
            if (prev[1] >= cur[0]) {
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                list.add(cur);
                prev = cur;
            }
        }

        for (int[] arr : list) {
            days -= (arr[1] - arr[0] + 1);
        }

        return days;
    }
}
