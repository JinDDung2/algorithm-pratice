# 숫자 게임
def solution(A, B):
    answer = 0
    A.sort()
    B.sort()
    idx = 0
    
    for i in range(len(B)):
        if A[idx] < B[i]:
            # print(f"a<b, i={i},idx={idx}")
            answer += 1
            idx += 1
    return answer