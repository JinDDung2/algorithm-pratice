# 모음 사전
from itertools import product
# https://docs.python.org/ko/3.8/library/itertools.html
def solution(word):
    lst = []

    for i in range(1, 6):
        lst += list(map(''.join, product('AEIOU', repeat = i)))

    lst.sort()
    answer = lst.index(word) + 1


    return answer


print(solution("AAAAE"))
# ls = []
# print(list(map(''.join, product('ABCD', repeat = 2))))