# 예산
def solution(d, budget):
    while sum(d) > budget:
        d.pop()
        # print(d)
    answer = len(d)

    return answer