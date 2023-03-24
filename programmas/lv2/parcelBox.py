# 택배 상자

from collections import deque

def solution(order):
    answer = 0
    order = deque(order)
    sub = []
    
    for i in range(1, len(order)+1):
        sub.append(i)
        while sub and order[0] == sub[-1]:
            answer += 1
            sub.pop()
            order.popleft()
        # print(f"i={i}, order={order}, sub={sub}, answer={answer}")
    return answer