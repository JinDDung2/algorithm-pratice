# 코딩테스트 고득점 Kit [스택/큐] 프린터
from collections import deque

def solution(priorities, location):
    answer = 0
    deq = deque([(v, i) for i, v in enumerate(priorities)])
    # print(deq)
    while deq:
        item = deq.popleft()
        if deq and item[0] < max(deq)[0]:
            deq.append(item)
        else:
            answer += 1
            if item[1] == location:
                break

    return answer

def try2(priorities, location):
    answer = 0
    q = deque()
    for i, v in enumerate(priorities):
        q.append((v, i))
    
    if q[location] == max(q):
        return 1
    
    while q:
        v, i = q.popleft()
        if q and v < max(q)[0]:
            q.append((v, i))
        else:
            answer += 1
            if i == location:
                break
        
    return answer


priorities1 = [2, 1, 3, 2]
priorities2 = [1, 1, 9, 1, 1, 1]
# print(solution(priorities1, 2))
print(solution(priorities2, 0))