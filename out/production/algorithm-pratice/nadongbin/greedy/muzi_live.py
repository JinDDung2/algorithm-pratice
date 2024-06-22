# 무지의 먹방 라이브
import heapq

def solution(food_times, k):
    answer = 0
    
    if sum(food_times) <= k:
        return -1
    
    q = []
    for i in range(len(food_times)):
        heapq.heappush(q, (food_times[i], i+1))
    
    sum_time = 0
    lenght = len(q)
    previous = 0
    
    while sum_time + (q[0][0] - previous) * lenght <= k:
        now = heapq.heappop(q)[0]
        sum_time += (now - previous) * lenght
        lenght -= 1
        previous = now
    
    result = sorted(q, key=lambda x:x[1])
    
    return result[(k - sum_time) % lenght][1]