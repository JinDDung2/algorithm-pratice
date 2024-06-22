# 야근지수
# 33.3/100
import heapq
def incorrect_solution(n, works):
    answer = 0
    
    # n이 works의 합보다 더 크면 0
    if n > sum(works):
        return answer
    
    # wokrs 내림차순 배열
    works.sort(reverse=True)
    # works의 값이 다음 값보다 크면 줄임
    idx = 0
    last = len(works)-1
    while n > 0:
        if idx == last:
            works[last] -= 1
            n -= 1
            idx = 0
        elif works[idx] >= works[idx+1]:
            works[idx] -= 1
            n -= 1
        elif works[idx] < works[idx+1]: 
            idx += 1
        
    for num in works:
        answer += num**2
    
    return answer

def solution(n, works):
    answer = 0
    if n >= sum(works): return answer
    
    heap = []
    
    for work in works:
        heapq.heappush(heap, -work)
    
    for _ in range(n):
        work = heapq.heappop(heap)
        work += 1
        heapq.heappush(heap, work)
    
    for num in heap:
        answer += num ** 2
    
    return answer