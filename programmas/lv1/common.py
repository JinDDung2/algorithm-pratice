# 최대공약수와 최소공배수
def solution(n, m):
    answer = [0, 0]
    a, b = min(n, m), max(n, m)

    for i in range(1, a+1):
        if a % i == 0 and b % i == 0:
            answer[0] = i

    answer[1] = (a*b)//answer[0]

    return answer