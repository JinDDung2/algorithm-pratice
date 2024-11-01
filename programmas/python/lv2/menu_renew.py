# 2021 KAKAO BLIND RECRUITMENT 메뉴 리뉴얼

from collections import Counter
from itertools import combinations


def solution(orders, course):
    answer = []
    for num in course:
        candidates = []
        for order in orders:
            for menu in combinations(order, num):
                # print("m", menu)
                temp = ''.join(sorted(menu))
                candidates.append(temp)
        # print(candidates)
        
        sorted_candidates = Counter(candidates).most_common()
        # print(sorted_candidates)
        for menu, cnt in sorted_candidates:
            if cnt > 1 and cnt == sorted_candidates[0][1]:
                answer.append(menu)
    return sorted(answer)