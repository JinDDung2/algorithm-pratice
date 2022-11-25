# 주식 가격
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
