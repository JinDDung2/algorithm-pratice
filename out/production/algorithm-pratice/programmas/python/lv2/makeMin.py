# 최솟값 만들기

def solution(A,B):
    answer = 0

    a_list = sorted(A)
    b_list = sorted(B, reverse=True)

    for i in range(len(A)):
        answer += a_list[i] * b_list[i]

    return answer


A = [1, 4, 2]
B = [5, 4, 4]

print(solution(A,B))
