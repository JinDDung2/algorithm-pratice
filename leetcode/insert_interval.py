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