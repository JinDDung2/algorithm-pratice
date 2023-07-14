# 연습문제 최고의 집합

def solution(n, s):
    if n > s:
        return [-1]
    elif s % n == 0:
        return [s/n] * n
    else:
        ## 11 --> 3 3 3 -> 3 4 4
        a = s // n
        b = s % n
        answer = [a] * n
        for i in range(n-1, n-1-b, -1):
            answer[i] += 1
    return answer