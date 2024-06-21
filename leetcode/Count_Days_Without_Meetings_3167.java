import java.util.Arrays;

class Count_Days_Without_Meetings_3167.java {
    public int countDays(int days, int[][] meetings) {
      // 시작점 기준 오름차순 정렬
      // e >= m[0] ? math.max(e, m[1]) : 작업1 days -= (e - s + 1) 작업2 s = m[0], e = m[1];
      // 마지막에도 days -= (e - s + 1)
        Arrays.sort(meetings, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        int s = meetings[0][0], e = meetings[0][1];
        for (int[] m : meetings) {
            if (m[0] <= e) {
                e = Math.max(e, m[1]);
            } else {
                days -= (e - s + 1);
                s = m[0];
                e = m[1];
            }
        }

        return days -= (e - s + 1);
    }
}
