# 2022 KAKAO TECH INTERNSHIP 두 큐 합 같게 만들기

from collections import deque

def solution(queue1, queue2):
    answer = 0
    q1 = deque(queue1)
    q2 = deque(queue2)
    
    sum1 = sum(q1)
    sum2 = sum(q2)
    
    while sum1 != sum2:
        if answer > (300000*2):
            return -1
        if sum1 > sum2:
            temp = q1.popleft()
            q2.append(temp)
            sum1 -= temp
            sum2 += temp
            answer += 1
        else:
            temp = q2.popleft()
            q1.append(temp)
            sum2 -= temp
            sum1 += temp
            answer += 1
        
    return answer