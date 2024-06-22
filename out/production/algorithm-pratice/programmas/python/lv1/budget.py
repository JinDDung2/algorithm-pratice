# 예산
def solution(d, budget):
    d_sort = sorted(d)
    # print(d_sort)
    while sum(d_sort) > budget:
        d_sort.pop()
        # print(d_sort)
    answer = len(d_sort)

    return answer