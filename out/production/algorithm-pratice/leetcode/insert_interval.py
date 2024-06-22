# insert interval

class Solution:
    def insert(self, intervals: list[list[int]], newInterval: list[int]) -> list[list[int]]:
        left = []
        right = []

        mergedIntervals = newInterval

        for s, e in intervals:
            if e < newInterval[0]:
                left.append([s, e])
            elif s > newInterval[1]:
                right.append([s, e])
            else:
                mergedIntervals[0] = min(mergedIntervals[0], s)
                mergedIntervals[1] = max(mergedIntervals[1], e)

        return left + [mergedIntervals] + right


'''java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();

        int[] temp = newInterval;
        for (int[] interval : intervals) {
            int s = interval[0];
            int e = interval[1];
            // 왼쪽(ie < new_is) + temp + 오른쪽(new_ie < is)
            if (e < temp[0]) {
                left.add(interval);
            } else if (s > temp[1]) {
                right.add(interval);
            } else {
            // temp -> min(temp[0], newInterval[0]), max(temp[1], newInterval[1])
                temp[0] = Math.min(temp[0], s);
                temp[1] = Math.max(temp[1], e);
            }
        }
        result.addAll(left);
        result.add(temp);
        result.addAll(right);

        return result.toArray(new int[result.size()][]);
    };
}
'''