# merge interval
class Solution:
    def merge(self, intervals: list[list[int]]) -> list[list[int]]:

        if len(intervals) == 1:
            return intervals

        intervals.sort(key= lambda x:x[0])
        result = []
        
        for s, e in intervals:
            if not result:
                result.append([s, e])
            elif result[-1][1] < s:
                result.append([s, e])
            else:
                result[-1][1] = max(result[-1][1], e)
        
        return result

'''java
class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] cur = intervals[0];
        for (int i=1; i<intervals.length; i++) {
            int[] next = intervals[i];
            // e >= next_s -> max(e, next_e)
            if (cur[1] >= next[0]) {
                cur[1] = Math.max(cur[1], next[1]);
            } else {
                result.add(cur);
                cur = next;
            }
        }
        // 나머지 1개
        result.add(cur);

        return result.toArray(new int[result.size()][]);
    }
}
'''