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