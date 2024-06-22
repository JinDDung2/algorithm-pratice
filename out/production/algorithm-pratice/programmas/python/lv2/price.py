# 코딩테스트 고득점 Kit [스택/큐] 주식 가격
from collections import deque

def solution(prices):
    answer = []
    queue = deque(prices)
    # print(queue)
    
    while queue:
        price = queue.popleft()
        time = 0
        for num in queue:
            time += 1
            if price > num:
                break
        answer.append(time)
    # print(answer)
    return answer

def try2(prices):
    answer = []
    
    q = deque(prices)
    
    while q:
        num = q.popleft()
        time = 0
        
        for p in q:
            time += 1
            if num > p:
                break
        
        answer.append(time)
    return answer
