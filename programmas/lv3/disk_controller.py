# 디스크 컨트롤러

import heapq

def solution(jobs):
    start = -1
    answer, now, idx = 0, 0, 0
    
    q = []
    
    while idx < len(jobs):
        for job in jobs:
            if start < job[0] <= now:
                heapq.heappush(q, (job[1], job[0]))
        
        if q:
            work = heapq.heappop(q)
            start = now
            now += work[0]
            answer += (now-work[1])
            idx += 1
        else:
            now += 1
    
        
    return int(answer / len(jobs))