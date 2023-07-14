# n^2 배열 자르기

def solution(n, left, right):
    answer = []
    for i in range(left, right+1):
        a = i//n
        b = i%n
        answer.append(max(a,b)+1)
    
    return answer