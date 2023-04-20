# 코딩테스트 고득점 Kit [힙] 더 맵게

import heapq

def solution(scoville, K):
    answer = 0
    heap = []
    for i in scoville:
        heapq.heappush(heap, i)
    # print(heap)
    
    while heap[0] < K:
        if len(heap) == 1:
            return -1
        
        a = heapq.heappop(heap)
        b = heapq.heappop(heap)
        hot = a + 2*b
        heapq.heappush(heap, hot)
        # print(f"a={a}, b={b}, hot={hot}, heap={heap}")
        answer += 1
        
    return answer

def try2(scoville, K):
    answer = 0
    heap = []
    
    for i in range(len(scoville)):
        heapq.heappush(heap, scoville[i])
    
    while heap[0] < K:
        if len(heap) == 1:
            return -1
        
        answer += 1
        fir = heapq.heappop(heap)
        sec = heapq.heappop(heap)
        
        heapq.heappush(heap, fir + sec*2)
    return answer